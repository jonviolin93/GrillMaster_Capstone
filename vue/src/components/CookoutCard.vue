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
    border: 2px solid rgb(231, 163, 15);
    border-radius: 10px;
    background: rgb(231, 163, 15);
    min-width: 200px;
    height: fit-content;
    margin: 10px;
    font-weight: 100;
}


.card .cookout-name {
    font-size: 1.5rem;
    font-weight: 400;
}

.cookout-date, .cookout-time, .cookout-location{
    font-size: 1rem;
    font-weight: 300;
}



</style>