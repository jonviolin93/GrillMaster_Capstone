<template>
  <div class="main">
      <h1>Information regarding this most honorable cookout</h1>
  
  
  <cookout-card/>
  <attendees-list />
  <menu-items />
  <place-order/>
  </div>
</template>

<script>

import AttendeesList from "../components/AttendeesList.vue"
import MenuItems from "../components/AttendeesList.vue"
import CookoutCard from "../components/CookoutCard.vue"
import PlaceOrder from "../components/PlaceOrder.vue"

export default {
    components:{ 
      AttendeesList,
      MenuItems,
      CookoutCard,
      PlaceOrder }

}
</script>

<style>
.main {
  display: flex;
  grid-template-columns: 1fr 1fr 1fr;

}



</style>