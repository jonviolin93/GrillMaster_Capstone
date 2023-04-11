<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <cookout-list/>
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
