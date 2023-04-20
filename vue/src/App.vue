<template>
  <div class="grill-master-app">
    <div id="app">
      <div id="nav">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link
        >&nbsp;|&nbsp;
        <router-link
          v-bind:to="{ name: 'create-cookout' }"
          v-if="$store.state.token != ''"
          >Create Cookout</router-link
        >&nbsp;|&nbsp;
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </div>

      <router-view />

      <footer class="footer">
        <h4 class="footer-text">
          Cookout App created by The GrillMasterz: Meli, Red, Cameron, Ellis,
          and Jonathan
        </h4>
      </footer>
    </div>
  </div>
</template>
<style>
html {
  background-color: black;
}

.grill-master-app {
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: 300;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: white;
}

a {
  color: white;
}

a:hover {
  background-color: orangered;
}

div#nav {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  color: white;
}

.footer {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left: 1%;
  margin-right: 1%;
}

.footer::before {
  content: "";
  background-size: cover;
  position: absolute;
  top: 0;
  bottom: 0;
  width: 100%;
  opacity: 0.66;
  border-radius: 10px;
  padding-top: 20px;
  display: inline-block;
  background-image: url("../src/assets/Coals.png");
  padding-bottom: 20px;
}

.footer-text {
  color: white;
  opacity: 100%;
  font-weight: 300;
  position: relative;
  font-size: calc(1rem + 1vh);
  line-height: 0.9;
}

@import url("https://fonts.googleapis.com/css2?family=Kanit:ital,wght@0,100;0,200;0,300;0,500;1,100;1,200;1,300;1,500&display=swap");
</style>