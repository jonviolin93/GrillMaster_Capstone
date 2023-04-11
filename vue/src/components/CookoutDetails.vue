<template>
  <div><h1>What's happenin with the cookout</h1>
     <menu-items/>
      <attendees-list/>
  </div>

</template>

<script>
import MenuItems from './MenuItems.vue';
import AttendeesList from './AttendeesList.vue';

export default {
    name: "cookout-details",
    components: {
       MenuItems,
       AttendeesList

    }

}
</script>

<style>

</style>