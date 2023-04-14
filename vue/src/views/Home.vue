<template>
  <div class="home">
   
    <div id="nav">
  
      <router-link v-bind:to="{ name: 'host' }">Host</router-link>&nbsp;|&nbsp;
   
    </div>


    
    <router-view />
    <section id="host">
      <router-link to="/create-cookout">
      <button id="create-cookout"></button>
      </router-link>
      <router-link v-bind:to="{ name: 'host' }">Home</router-link>&nbsp;|&nbsp;
    </section>
    <section id="attendee"></section>
    <section id="chef"></section>
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <cookout-list/>
    <footer>
      <h4>Footer Text</h4>
    </footer>
  </div>
</template>

<script>
import CookoutList from "../components/CookoutList.vue"

export default {
  name: "home",
  components: {
    CookoutList
  }
};
</script>
<style scoped>

footer {
  display: flex;
  flex-direction: column;
  background-image: url("../assets/Coals.png");
  max-height: 20vh;
  align-items: center;
  justify-content: center;
  padding: 20vw;
  
}
</style>
