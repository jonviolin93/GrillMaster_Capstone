<template>
  <div class="menu-details">
    <label id="header"><h2>Menu Items</h2></label>
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
      <div class="break"></div>
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
  grid-column: 1;
}

#header {
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
  padding-left: 5rem;
  padding-right: 5rem;
}

h2 {
  font-weight: 300;
}

form {
  justify-items: center;
  width: 60%;
  padding-left: 20%;
}

.menu-foodList {
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
  font-weight: 200;
}

p {
  margin: 5px;
}

.break {
  flex-basis: 100%;
  height: 0;
}

.button {
align-content: center;
  background-color: black;
  color: white;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: 300;
  margin-top: 5px;
  margin-bottom: 5px;
  border-radius: 10px;
  background-color: rgb(231, 163, 15);

}

.button:hover{
  background-color: #bb2b1b;
}
</style>