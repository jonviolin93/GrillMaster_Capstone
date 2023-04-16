<template>
  <div class="card" >
      <h2 class="cookout-name">{{ CookoutDetails.name }}</h2>
      <h3 class="host"> {{ CookoutDetails.host }} </h3>
      <h4 class="cookout-date"> {{CookoutDetails.date}}
      <img class="cookout-image"  v-bind:src="'../assets/logo.png'" >
   
  </div>
</template>

<script>
export default {
    name: 'cookout-card',
    props: {
        Cookout: Object
    },
  

    }

</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    position: relative;
}


.card .cookout-name {
    font-size: 1.5rem;
}

.card .host {
    font-size: 1rem;
}

.cookout-image {
    width: 20%;
}


</style>