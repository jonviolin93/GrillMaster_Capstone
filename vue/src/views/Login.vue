<template>
  <div class="background" id="login">
    <form @submit.prevent="login">
      <div class="transbox">
        <h1>Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="user.username" required />
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
        <button type="submit" style="align-self: center">Sign in</button>
        <p>
          <router-link :to="{ name: 'register' }">
            Need an account? Sign up.
          </router-link>
        </p>
      </div>
    </form>
    <footer></footer>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
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
  border-radius: 10px;
  padding-top: 20px;
  padding-bottom: 20px;
  width: 60%;
  opacity: 0.65;
  background-color: orangered;
  border: 5px solid black;
}

#username,
#password {
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