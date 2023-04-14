<template>
  <div class="background"  id="login" >
    <form class="transbox"  @submit.prevent="login">
      <h1>Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
        <router-link :to="{ name: 'register' }"
          >Need an account? Sign up.</router-link
        >

      </p>
      
 
      
    
    </form>
   <footer>

   </footer>

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
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

form {
  display: flex;
  flex-direction: column;

  justify-content: space-evenly;
  flex-wrap: wrap;

  align-items: center;
  font-family: "Indie Flower", Arial, Helvetica, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0px;
}
form.transbox{
  margin: 60px 240px 160px 240px;
  opacity: 0.7;
  background-color: orangered;
  font-weight: bold;
  color: black;
 
  border: 5px solid black;

}


input#username {
  background-color: orange;
}
input#password {
  background-color: orange;
}
h2 {
  display: flex;
  flex-direction: row;
}
footer {
  display: flex;
  flex-direction: column;
}
div#login{
  background-image: url("../assets/Coals.png");
  background-size: cover;
 
}

@import url("https://fonts.googleapis.com/css2?family=Indie+Flower&display=swap");
</style>