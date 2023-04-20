<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <div class="transbox">
        <h1>Create Account</h1>
        <div role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div class="form-input-group">
          <label for="username">Username</label>
          <input
            type="text"
            id="username"
            v-model="user.username"
            required
            style="align-self: flexbox-start"
          />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input
            type="password"
            id="password"
            v-model="user.password"
            required
          />
        </div>
        <div class="form-input-group">
          <label for="confirmPassword">Confirm Password</label>
          <input
            type="password"
            id="confirmPassword"
            v-model="user.confirmPassword"
            required
          />
        </div>
        <button type="submit" style="align-self: center">Create Account</button>
        <p>
          <router-link :to="{ name: 'login' }"
            >Already have an account? Log in.</router-link
          >
        </p>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
form {
  display: flex;
  background-image: url("../assets/Coals.png");
  background-size: cover;
  align-items: center;
  justify-content: center;
  padding: 20vw;
}

h1 {
  font-weight: 300;
}

.transbox {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  padding-top: 20px;
  padding-bottom: 20px;
  border-radius: 10px;

  width: 60%;

  opacity: 0.65;
  background-color: orangered;
  border: 5px solid black;
}

input#username,
#password,
#confirmPassword {
  background-color: orange;
  border-radius: 10px;
  margin-right: 1%;
}

h2 {
  display: flex;
  flex-direction: row;
}

footer {
  display: flex;
  flex-direction: column;
}

.form-input-group {
  margin-bottom: 10px;
}

label {
  display: inline-block;
  width: 150px;
  text-align: right;
  margin-right: 0.5rem;
}
button {
  background-color: black;
  color: white;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: 300;
  margin-top: 5px;
  border-radius: 10px;
  background-color: rgb(231, 163, 15);
 
}

@media (max-width: 425px) {
  .transbox {
    flex-basis: 100%;
    width: 80%;
  }
  form {
    padding: 20px;
  }
  label {
    display: inline-block;
    width: 150px;
    text-align: left;
    margin-right: 0.5rem;
  }
}
</style>
