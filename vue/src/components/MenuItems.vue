<template>
  <div class="menu-details">
    <label for="menu-name" id="g1">Menu Name</label>
    <h2 class="menu-name" id="g3">{{ menu.name }}</h2>
    <label for="menu-foodList" id="g2">Menu Items</label>
    <p class="menu-foodList" v-for="food in menu.foodItems" v-bind:key="food.index">{{ food.name }}</p>
  </div>
</template>

<script>
export default {
  name: "menu-items",
  props: {
    menu: Object,
  },
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
/* #g4 {
  grid-area: g4;
  background-color: rgb(231, 163, 15);
}
#g5 {
  grid-area: g5;
  margin: 5px;
}
#g6 {
  grid-area: g6;
  margin: 5px;
}
#g7 {
  grid-area: g7;
}
#g8 {
  grid-area: g8;
}
#g9 {
  grid-area: g9;
}
#g10 {
  grid-area: g10;
} */
</style>