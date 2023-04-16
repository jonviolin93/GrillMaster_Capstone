<template>
  <div>
      <h1>Information regarding this most honorable cookout</h1>
  <cookout-card/>
  <attendees-list />
  <menu-items />
  </div>
</template>

<script>

import AttendeesList from "../components/AttendeesList.vue"
import MenuItems from "../components/AttendeesList.vue"
import CookoutCard from "../components/CookoutCard.vue"
export default {
    components:{ 
     
      AttendeesList,
      MenuItems,
      CookoutCard }

}
</script>

<style>

</style>