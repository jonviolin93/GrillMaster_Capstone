<template>
  <div>
    <header>Grill Master</header>
    <h1>ORDERS</h1>
    <div id="order-boxes" class="flexbox" v-for="order in this.$store.state.orders" v-bind:key="order.id">
      {{order.username}} Time:{{order.time}}
      <div id="order-food">
      <div id="order-food" v-for="food in order.foodList" v-bind:key="food.id">{{food.name}} Quantity:{{food.quantity}}</div>
      </div>
      <button v-if="!order.complete" v-on:click="bumpOrder(order.id)">BUMP</button>
      <p v-else>Order Up!</p>
    
    </div>
    
  <short-order/>
  <place-order/>

  </div>
</template>

<script>
import ShortOrder from "../components/ShortOrder.vue"
import PlaceOrder from "../components/PlaceOrder.vue"
import OrderService from "../services/OrderService"
export default {
    components: {
        ShortOrder,
        PlaceOrder
    },
created() {
    const cookoutId = this.$route.params.id;
    
    this.$store.dispatch("listOrders", cookoutId);
  },
methods: {
  bumpOrder(id){
    OrderService.completeOrder(id)
    this.$router.go()
  }
}

}
</script>

<style>
header{
 height: 120px;
  top: 0;
  bottom: 0;
  width:100%;
  opacity: 0.66;
  border-radius: 10px;
  display: flex;
  background-image: url("../assets/Coals.png");
  background-size: cover;
  padding: 0 20px;
align-items: center;
justify-content: center;
  font-weight: 600;
 position: relative;  
  font-size: calc(1rem + 1.8vh);
  line-height: 0.9;
}
h1{
  display: flex;
 align-items: center;
 justify-content: center;
  flex-direction: row;
  background-color: #BB2B1B;
  border-radius: 10px; 
max-width:65%;
padding-left: auto;
}
button{
  display: inline-block;
  background-color:#BB2B1B;
  border-radius: 10px;

}
div#order-boxes{
  background-color:  rgb(231, 163, 15);
  display: inline-flex;
  border: black;
  border-radius: 15px 15px 15px 15px;
  max-width: 100%;
margin-top: 8px;
  justify-content: space-between;


}
div#order-food{
  display: flex;
  flex-wrap: wrap;
border: 10px, black;
border-bottom: 10px;

}

</style>