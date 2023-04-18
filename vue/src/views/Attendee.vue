<template>
  <div>
    <h1>What's happenin with the cookout</h1>
    <body>
      
      <div id="cookout-details">
        //TODO could include what they want to bring
        <cookout-card />
      </div>
      <section id="menu-order-form">
        <form class="order-form">
          <div class="form-input-group">
            <label for="order-add">Search</label>
            <select v-model="item.menuId">
              <option
                v-for="(item) in menuItems"
                v-bind:key="item.menuId"
              >
                {{ item.name }}
              </option>
            </select>

            <select
              name="order-add"
              id="order-add"
              required
              style="align-self: flexbox-start"
            />
          </div>
        </form>
        <menu-items />
      </section>
      <div id="attendee-list">
        <attendees-list />
      </div>
      <div id="order-ready">//TODO order ready</div>
    </body>

    <place-order />
  </div>
</template>
<script>
import CookoutCard from "../components/CookoutCard.vue";
import MenuItems from "../components/MenuItems.vue";
import AttendeesList from "../components/AttendeesList.vue";
import PlaceOrder from "../components/PlaceOrder.vue";

export default {
  name: "attendee",
  data() {
    return {
      menuItems: [
        {
          id: "",
          name: "",
          isFavorited: false,
          foodList: [],
        },
      ],
    };
  },

  components: {
    CookoutCard,
    MenuItems,
    AttendeesList,
    PlaceOrder,
  },
  created() {
    const cookoutId = this.$route.params.id;
    const menuId = this.$store.state.attendCookouts.forEach(cookout => {
      if (cookout.id == cookoutId) {
        return cookout.menuId;
      }
    })
    this.$store.dispatch("listMenu", menuId)
  },
};
</script>
<style scoped>
</style>