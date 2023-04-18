<template>
  <div>
    <body>
      <h1>What's happenin with the cookout</h1>
      <div id="cookout-details">
        //TODO could include what they want to bring
        <cookout-card />
      </div>
      <div class="row-2">
        <section id="menu-order-form">
          <form class="order-form">
            <div class="form-input-group">
              <label for="order-add">Search</label>
              <div>
                <select>
                  <option v-for="item in $store.state.menuItems.foodList" v-bind:key="item.id">
                    {{ item.name }}
                  </option>
                </select>
              </div>
            </div>
          </form>
        </section>
        <div id="attendee-list">
          <attendees-list />
        </div>
        <div id="order-ready">//TODO order ready</div>
      </div>
    </body>

    <place-order />
  </div>
</template>
<script>
import CookoutCard from "../components/CookoutCard.vue";
import AttendeesList from "../components/AttendeesList.vue";
import PlaceOrder from "../components/PlaceOrder.vue";

export default {
  name: "attendee",

  components: {
    CookoutCard,
    AttendeesList,
    PlaceOrder,
  },

  created() {
    const cookoutId = this.$route.params.id;
    let menuId;
    this.$store.state.hostedCookouts.forEach((cookout) => {
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
body {
  display: flex;
  direction: column;
}

#cookout-details,
.row-2 {
  display: flex;
  direction: row;
}

/* form {
  display: flex;
  background-image: url("../assets/Coals.png");
  background-size: cover;
  align-items: center;
  justify-content: center;
  padding: 20vw;
} */
</style>