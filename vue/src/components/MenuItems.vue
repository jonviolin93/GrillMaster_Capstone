<template>
  <div class="menu-details">
    <label for="menu-name" id="g1">Menu Name</label>
    <h2 class="menu-name" id="g3">{{ menu.name }}</h2>
    <label for="menu-foodList" id="g2">Menu Items</label>
    <form v-on:submit.prevent="placeOrder">
      <div class="menu-foodList" v-for="food in menu.foodItems" v-bind:key="food.index">
        <input type="checkbox" :value=food v-model="selectedFoods"/>
          {{ food.name }}
        <select name="quantity" id="quantity" v-model="food.quantity">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
        </select>
      </div>
      <input class="button" type="submit" value="Place Order"/>
    </form>
    
  </div>
</template>

<script>
import OrderService from '../services/OrderService';
export default {
  name: "menu-items",
  data() {
    return {
      selectedFoods: []
    }
  },
  props: {
    menu: Object,
  },
  methods: {
    placeOrder() {
      const order = {
        foodList: this.selectedFoods
      }
      OrderService.placeOrder(this.$route.params.id, order)
      .then(response => {
        if (response.status == 201){
          console.log("success")
        }
      })
    }
  }
};
</script>

<style scoped>
.menu-details {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "g1 g2"
    "g3 p"; 
}

#g1 {
  grid-area: g1;
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
}
#g2 {
  grid-area: g2;
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
  padding-left: 5rem;
  padding-right: 5rem;
}
#g3 {
  grid-area: g3;
  
  margin: 5px;
}
p {
  margin: 5px;
}

.button {
  background-color: black;
  color: white;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: 300;
  margin-top: 5px;
  border-radius: 10px;
  background-color: rgb(231, 163, 15);

}

.button:hover{
  background-color: #bb2b1b;
}
</style>