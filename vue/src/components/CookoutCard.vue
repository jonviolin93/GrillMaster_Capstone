<template>
  <div class="card" >
      <h2 class="cookout-name">{{ cookout.name }}</h2>
      <h4 class="cookout-date"> {{cookout.date}}</h4>
      <h4 class="cookout-time"> {{cookout.time}}</h4>
      <h4 class="cookout-location"> {{cookout.location}}</h4>
  </div>
</template>

<script>
export default {
    name: 'cookout-card',
    props: ["cookout"],
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