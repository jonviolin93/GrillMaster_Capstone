<template>
  <div>
    <div class="header">
      <p id="header-text">Information regarding this most honorable cookout</p>
    </div>
    <body>
      <div id="cookout-details">
        <cookout-details-comp v-bind:cookout="getCookoutDetails" />
      </div>
      <section id="flexbox">
        <div id="menu-details">
          <menu-items v-bind:menu="getMenuDetails" />
        </div>
        <div id="place-order">
          <place-order />
        </div>
      </section>
    </body>
  </div>
</template>

<script>
import CookoutDetailsComp from "../components/CookoutDetailsComp.vue";
import PlaceOrder from "../components/PlaceOrder.vue";
import MenuItems from "../components/MenuItems.vue";

export default {
  name: "host",
  components: { MenuItems, PlaceOrder, CookoutDetailsComp },
  computed: {
    getCookoutDetails() {
      let oneCookoutDetails = this.$store.state.attendCookouts.find((item) => {
        return item.cookoutId == this.$route.params.cookoutId;
      });
      return oneCookoutDetails;
    },
    getMenuDetails() {
      let oneMenuDetails = this.$store.state.menuItems.find((item) => {
        return item.menuId == this.$route.params.menuId;
      });
      return oneMenuDetails;
    },
  },

  created() {
    const cookoutId = this.$route.params.id;
    let menuId;
    this.$store.state.attendCookouts.forEach((cookout) => {
      if (cookout.id == cookoutId) {
        menuId = cookout.menuId;
        console.log(menuId);
      }
    });
    console.log(menuId);
    this.$store.dispatch("listMenu", menuId);
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

#cookout-details {
  background-color: #bb2b1b;
  border-radius: 10px;
}

#flexbox {
  display: grid;
  grid-template-columns:  2fr 1fr;
}

#menu-details {
  background-color: #bb2b1b;
  border-radius: 10px;
  flex-grow: 60vw;
  margin-top: 5px;
  margin-right: 5px;
}

#place-order {
  background-color: #bb2b1b;
  border-radius: 10px;
  flex-grow: 40vw;
  margin-top: 5px;
  margin-left: 5px;
}
</style>