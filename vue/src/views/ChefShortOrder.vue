<template>
  <div>
    <div class="header">
      <p id="header-text">Grill Master</p>
    </div>
    <div>
      <h1>ORDERS</h1>
    </div>
    <div class="flexbox">
      <div
        id="order-boxes"
        v-for="order in this.$store.state.orders"
        v-bind:key="order.id"
        v-show="!order.complete"
      >
        <div class="nameandtime">
          <p>{{ order.username }}</p>
          <p>Time: {{ order.time }}</p>
        </div>
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
      </div>
    </div>
  </div>
</template>

<script>
import OrderService from "../services/OrderService";

export default {
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

.flexbox {
  display: flex;
  flex-direction: column;
}

#order-boxes {
  display: flex;
  margin-top: 8px;
  padding: 10px;
  gap: 1em;
}

.nameandtime {
  text-align: left;
  display: flex;
  flex-direction: column;
  gap: 0.25em;
  white-space: nowrap;
  width: 15%;
}

.nameandtime > p {
  margin: 0;
}

#order-food {
  display: flex;
  flex-wrap: wrap;
  padding: 15px;
  background-color: rgb(231, 163, 15);
  border-radius: 15px;
  flex: 1 1 0%;
}

button {
  display: inline-block;
  background-color: #bb2b1b;
  border-radius: 10px;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: 300;
  color: white;
  padding-left: 2em;
  padding-right: 2em;
}

@media (max-width: 769px) {
  h1 {
    max-width: 100%;
  }

  #order-boxes {
    flex-direction: column;
  }
}
</style>