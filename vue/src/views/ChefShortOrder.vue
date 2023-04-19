<template>
  <div>
    <header>Grill Master</header>
    
    <div id="headline">
    <h1>ORDERS</h1>
    </div>
<div id="align" class="flexbox">
  
    <div id="order-boxes" class="flexbox" v-for="order in this.$store.state.orders" v-bind:key="order.id" >
      {{order.username}} | Time: {{order.time}}
    
      <div id="order-food">
      <div id="order-food" v-for="food in order.foodList" v-bind:key="food.id">{{food.name}} | Quantity: {{food.quantity}}</div>
      </div>
      

      <button v-if="!order.complete" v-on:click="bumpOrder(order.id)">BUMP</button>
      <p v-else>ORDER UP!</p>
    
    </div>
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
  data(){
    return {
      isVisible: true
    }
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
justify-content: center;
align-items: center;
  flex-direction: row;
  background-color: #BB2B1B;
  border-radius: 10px; 
width: 100%;


}
button{
  display: inline-block;
  background-color:#BB2B1B;
  border-radius: 10px;
  margin: 8px;
  border-block-color: black;
  width: 20%;
  height: 20%;
  

}
div#order-boxes{
  background-color:  rgb(231, 163, 15);
  display: inline-flex;
  border: black;
  border-radius: 15px 15px 15px 15px;
  max-width: 100%;
margin-top: 8px;
  justify-content: space-between;
  padding: 10px;
 background-color: black;


}

div#order-food{
  display: flex;
  flex-wrap: wrap;
justify-content: center;
align-items: center;
padding: 15px;
background-color:  rgb(231, 163, 15);
border-radius: 15px;
width: 90%;

}
div#align{
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  
}
p{
   display: inline-block;
  background-color:#BB2B1B;
  border-radius: 10px;
  margin: 8px;
  border: black;
border-width: 10px;

padding: 10px;
font-weight: bold;
font-size: 80%;
}

@media(max-width: 769px){
 
 h1{
 max-width: 100%;
}
}

</style>