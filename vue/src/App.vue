<template>
  <main>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'create-cookout' }" v-if="$store.state.token != ''">Create Cookout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
   
    <router-view />
     
  </div>
  </main>
</template>
<style>
html {
  background-color: black;
}

main {
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

a:hover{
  background-color: orangered;
}

div#nav{
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  color: white;
}

@import url('https://fonts.googleapis.com/css2?family=Kanit:ital,wght@0,100;0,200;0,300;0,500;1,100;1,200;1,300;1,500&display=swap');

</style>