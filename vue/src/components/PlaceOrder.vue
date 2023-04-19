<template>
  <div>
<<<<<<< HEAD
    A form to place an order that the chef will see
    <label for="order-add">Search</label>
    <div v-for="item in $store.state.menuItems.foodList" v-bind:key="item.id">
      {{ item.name }}
    </div>
    <div>
      <button>Is Your Order Ready</button>
    </div>
=======
      <menu-items/>
>>>>>>> c99fd993667cc23960f3742f782feca68db320eb
  </div>
</template>

<script>
export default {
  name: "place-order",
  components: {},
};
</script>

<style>
</style>