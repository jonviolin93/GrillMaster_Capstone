<template>
  <div><h1>What's happenin with the cookout</h1>
     <menu-items/>
      <attendees-list/>
      <cookout-card/>
      <cookout-list/>
      <place-order/>
  </div>

</template>
<script>
import CookoutList from "../components/CookoutList.vue"
import CookoutCard from "../components/CookoutCard.vue"
import MenuItems from "../components/MenuItems.vue"
import AttendeesList from "../components/AttendeesList.vue"
import PlaceOrder from "../components/PlaceOrder.vue"

export default{
  components:{
    CookoutList,
    CookoutCard,
    MenuItems,
    AttendeesList,
    PlaceOrder

  }

  
}
</script>
<style scoped>

</style>