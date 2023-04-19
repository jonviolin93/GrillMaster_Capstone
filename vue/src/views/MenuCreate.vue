<template>
  <div>
      <form v-on:submit.prevent="findExternalFoods">
          <label for="ingredient">Ingredient:</label>
          <input type="text" name="ingredient" id="ingredient" v-model="ingredient" />
          <label for="restriction">Dietary Restriction:</label>
          <select name="restriction" id="restriction" v-model="restriction">
              <option value="">&nbsp;</option>
              <option value="gluten-free">Gluten-free</option>
              <option value="tree-nut-free">Tree nut-free</option>
              <option value="vegan">Vegan</option>
              <option value="vegetarian">Vegetarian</option>
          </select>
          <label for="dishType">Dish Type:</label>
          <select name="dishType" id="dishType" v-model="dishType">
              <option value="">&nbsp;</option>
              <option value="generic-meals">Homemade Plates</option>
              <option value="fast-foods">Fast Food Grabs</option>
              <option value="packaged-foods">Pre-made Options</option>
          </select>
          <input type="submit" value="Search"/>
      </form>
      <form v-on:submit="submitFoodsToMenu">
      <div v-for="(food, index) in this.foodReturn" v-bind:key="index">
          <input type="checkbox" :value=food v-model="selectedFoods"/>
          {{food.name}}
          <select name="category" id="category" v-model="food.category">
              <option value="Main">Main</option>
              <option value="Side">Side</option>
              <option value="Dessert">Dessert</option>
              <option value="Drink">Drink</option>
          </select>
      </div>
      <input type="submit" value="Add Selected to Menu"/>
      </form>
      

  </div>
</template>

<script>
import MenuService from '../services/MenuService'
export default {
    data() {
        return {
            ingredient: '',
            restriction: '',
            dishType: '',
            foodReturn: {},
            selectedFoods: []
        }
    },
    methods: {
        findExternalFoods() {
            MenuService.searchFoods(this.ingredient, this.restriction, this.dishType)
            .then(response => {
                this.foodReturn = response.data
            })
        },
        submitFoodsToMenu() {
            const foodsInMenu = []
            this.selectedFood.forEach(food => {
                MenuService.addFoodToDatabase(food)
                .then(response => {
                    food.id = response.data;
                    foodsInMenu.push(food);
                })    
            })
            const menu = {
                "name": "",
                "favorited": false,
                "foodItems": foodsInMenu
            }
            MenuService.updateMenu(this.$route.params.id, menu)
        }
    }
}
</script>

<style>

</style>