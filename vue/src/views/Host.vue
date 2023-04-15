<template>
  <div>
      <h1>Information regarding this most honorable cookout</h1>
  <cookout-details/>
  <attendees-list />
  <menu-items />
  </div>
</template>

<script>
import CookoutDetails from "../components/CookoutDetails.vue"
import AttendeesList from "../components/AttendeesList.vue"
import MenuItems from "../components/AttendeesList.vue"
export default {
    components:{ 
      CookoutDetails,
      AttendeesList,
      MenuItems }

}
</script>

<style>

</style>