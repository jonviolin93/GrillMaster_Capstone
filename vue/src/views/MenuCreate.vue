<template>
  <div>
    <div class="header">
      <p id="header-text">Add Items to Menu</p>
    </div>
    <div id="form-div">
    <form v-on:submit.prevent="findExternalFoods">
      <div>
        <label for="ingredient">Ingredient:</label>
        <input
          type="text"
          name="ingredient"
          id="ingredient"
          v-model="ingredient"
        />
      </div>
      <div>
        <label for="restriction">Dietary Restriction:</label>
        <select name="restriction" id="restriction" v-model="restriction">
          <option value="">&nbsp;</option>
          <option value="gluten-free">Gluten-free</option>
          <option value="tree-nut-free">Tree nut-free</option>
          <option value="vegan">Vegan</option>
          <option value="vegetarian">Vegetarian</option>
        </select>
      </div>
      <div>
        <label for="dishType">Dish Type:</label>
        <select name="dishType" id="dishType" v-model="dishType">
          <option value="">&nbsp;</option>
          <option value="generic-meals">Homemade Plates</option>
          <option value="fast-foods">Fast Food Grabs</option>
          <option value="packaged-foods">Pre-made Options</option>
        </select>
      </div>
      <div>
        <input type="submit" value="Search" />
      </div>
    </form>
    <form id="add" v-on:submit.prevent="submitFoodsToMenu">
      <div v-for="(food, index) in this.foodReturn" v-bind:key="index">
        <input type="checkbox" :value="food" v-model="selectedFoods" />
        {{ food.name }}
        <select name="category" id="category" v-model="food.category">
          <option value="Main">Main</option>
          <option value="Side">Side</option>
          <option value="Dessert">Dessert</option>
          <option value="Drink">Drink</option>
        </select>
      </div>
      <div>
        <input type="submit" value="Add Selected to Menu" />
      </div>
    </form>
    </div>
    <div id="food-div">
      <p id="food-selected" v-for="food in selectedFoods" :key="food.index">
        {{ food.name }}, {{ food.category }}
      </p>
    </div>

    <router-link
      :to="{
        name: 'add-attendees',
        params: { id: this.$route.params.cookoutId },
      }"
      >Invite users --></router-link
    >
  </div>
</template>

<script>
import MenuService from "../services/MenuService";
export default {
  name: "CreateMenu",
  data() {
    return {
      ingredient: "",
      restriction: "",
      dishType: "",
      foodReturn: {},
      selectedFoods: [],
    };
  },
  created: {},
  methods: {
    findExternalFoods() {
      MenuService.searchFoods(
        this.ingredient,
        this.restriction,
        this.dishType
      ).then((response) => {
        this.foodReturn = response.data;
      });
    },
    submitFoodsToMenu() {
      console.log("This was reached");
      const foodsInMenu = [];
      let count = 0;
      let length = this.selectedFoods.length;
      this.selectedFoods.forEach((food) => {
        food.addedBy = this.$store.state.user.username;
        MenuService.addFoodToDatabase(food).then((response) => {
          console.log("This loop was reached");
          food.id = response.data;
          foodsInMenu.push(food);
          count++;

          if (count == length) {
            const menu = {
              name: "",
              favorited: false,
              foodItems: foodsInMenu,
            };
            MenuService.updateMenu(this.$route.params.menuId, menu);
            console.log("This was reached end");
          }
        });
      });

      // const menu = {
      //     "name": "",
      //     "favorited": false,
      //     "foodItems": foodsInMenu
      // }
      // MenuService.updateMenu(this.$route.params.id, menu)
      // console.log("This was reached end")
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

label {
  display: inline-block;
  width: 150px;
  text-align: right;
 
}

div {
  margin-bottom: 10px;
}


#header {
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
  padding-left: 5rem;
  padding-right: 5rem;
  grid-column: span 2;
}

h2 {
  font-weight: 300;
}



#cookout-details {
  background-color: #bb2b1b;
  border-radius: 10px;
}

#flexbox {
  display: grid;
  grid-template-columns: 1fr 1fr;
}

#menu-details {
  background-color: #bb2b1b;
  border-radius: 10px;
  margin-top: 5px;
  margin-right: 5px;
  width: 1fr;
}


form{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color:  #bb2b1b;
  padding-left: 20%;
  padding-right: 20%;
  padding-top: 2%;
 border-radius: 10px;
}
input{
  background-color:  rgb(231, 163, 15);
  border-radius: 10px;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
 
  color: white;
}
select{
  background-color:  rgb(231, 163, 15);
  border-radius: 10px;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: bold;
  color: white;
}
#form-div{
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  justify-content: center;
  align-items: center;
}
#add{
  border-top-right-radius: 0px;
  border-top-left-radius: 0px;
}
#food-selected{
  display: inline block;
  background-color: #bb2b1b;
align-items: center;
  justify-content: center;
 
 border-radius: 10px;
 max-width: 60%;
}
#food-div{
  width: 60%;
  align-items: center;
  justify-content: space-evenly;
  padding-left: 33%;
}

@media(max-width: 850px){
  label{
    text-align: top;
  }
  form{
    justify-content: center;
    align-items: center;
  }
}
</style>