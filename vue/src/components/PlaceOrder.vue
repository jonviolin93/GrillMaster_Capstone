<template>
  <div>A form to place an order that the chef will see
      <menu-items/>
  </div>

</template>

<script>

import MenuItems from "./MenuItems.vue"
export default {
name: "place-order",
components: {
MenuItems
  
}
}
</script>

<style>

</style>