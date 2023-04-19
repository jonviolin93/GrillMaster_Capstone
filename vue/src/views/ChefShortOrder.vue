<template>
  <div>
    <div class="header">
    <p id="header-text">Grill Master</p>
</div>
    <div>
      <h1>ORDERS</h1>
    </div>
    <div id="align" class="flexbox">
      <div
        id="order-boxes"
        class="flexbox"
        v-for="order in this.$store.state.orders"
        v-bind:key="order.id"
      >
        {{ order.username }} | Time: {{ order.time }}

        <div id="order-food">
          <div
            id="order-food"
            v-for="food in order.foodList"
            v-bind:key="food.id"
          >
            {{ food.name }} | Quantity: {{ food.quantity }}
          </div>
        </div>

        <button v-if="!order.complete" v-on:click="bumpOrder(order.id)">
          BUMP
        </button>
        <p id="order-up" v-else>ORDER UP!</p>
      </div>
      <div>
        <short-order />
      </div>
    </div>
  </div>
</template>

<script>
import ShortOrder from "../components/ShortOrder.vue";

import OrderService from "../services/OrderService";
export default {
  components: {
    ShortOrder,
   
  },
  created() {
    const cookoutId = this.$route.params.id;

    this.$store.dispatch("listOrders", cookoutId);
  },
  data() {
    return {
      isVisible: true,
    };
  },
  methods: {
    bumpOrder(id) {
      OrderService.completeOrder(id);
      this.$router.go();
    },
  },
};
</script>

<style scoped>
.header {
  position: relative;
  width: 70%;
  display: flex;
  align-items: center;
  justify-content: center;
  left: 15%;
  right: 15%;
}

.header:before {
  content: "";
  background-size: cover;
  position: absolute;
  top: 0;
  bottom: 0;
  width: 100%;
  opacity: 0.66;
  border-radius: 10px;
  display: inline-block;
  background-image: url("../assets/Coals.png");
  padding: 0 20px;
}

#header-text {
  color: white;
  opacity: 100%;
  font-weight: 300;
  position: relative;
  font-size: calc(1rem + 1.8vh);
  line-height: 0.9;
}

h1 {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row;
  background-color: #bb2b1b;
  border-radius: 10px;
  width: 100%;
}
button {
  display: inline-block;
  background-color: #bb2b1b;
  border-radius: 10px;
  margin: 8px;
  border-block-color: black;
  width: 20%;
  height: 20%;
 font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: bold;
  color: white;
}

short-order {
  display: flex;
}

div#order-boxes {
  background-color: rgb(231, 163, 15);
  display: inline-flex;
  border: black;
  border-radius: 15px 15px 15px 15px;
  max-width: 100%;
  margin-top: 8px;
  justify-content: space-between;
  padding: 10px;
  background-color: black;
}

div#order-food {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  padding: 15px;
  background-color: rgb(231, 163, 15);
  border-radius: 15px;
  width: 90%;
}
div#align {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
}
#order-up{
  display: inline-block;
  background-color: #bb2b1b;
  border-radius: 10px;
  margin: 8px;
  border: black;
  border-width: 10px;

  padding: 10px;
  font-weight: bold;
  font-size: 80%;
}


@media (max-width: 769px) {
  h1 {
    max-width: 100%;
  }
}
</style>