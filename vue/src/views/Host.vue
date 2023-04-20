<template>
  <div>
    <div class="header">
      <p id="header-text">Host</p>
    </div>
   
    <body>
      <div id="cookout-details">
        <cookout-details-comp v-bind:cookout="getCookoutDetails" />
      </div>
      <section id="flexbox">
        <div id="menu-details">
          <menu-items v-bind:menu=this.$store.state.menuItems />
        </div>
        <div id="attendees-list">
          <attendees-list v-bind:attendees="getAttendeeList" />
        </div>
      </section>
    </body>
  </div>
</template>

<script>
import AttendeesList from "../components/AttendeesList.vue";
import CookoutDetailsComp from "../components/CookoutDetailsComp.vue";
import MenuItems from "../components/MenuItems.vue";

export default {
  name: "host",
  components: { MenuItems, CookoutDetailsComp, AttendeesList },
  computed: {
    getCookoutDetails() {
      let oneCookoutDetails = this.$store.state.hostedCookouts.find((item) => {
        return item.id == this.$route.params.id;
      });
      return oneCookoutDetails;
    },

    getAttendeeList() {
      let attendeeList = this.$store.state.hostedCookouts.find((item) => {
        return item.id == this.$route.params.id;
      });
      return attendeeList.attendees;
    },
  },

  created() {
    const cookoutId = this.$route.params.id;
    let menuId;
    this.$store.state.hostedCookouts.forEach((cookout) => {
      if (cookout.id == cookoutId) {
        menuId = cookout.menuId;
      }
    });
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
  grid-template-columns: 1fr 1fr;
}

#menu-details {
  background-color: #bb2b1b;
  border-radius: 10px;
  margin-top: 5px;
  margin-right: 5px;
}

#attendees-list {
  background-color: #bb2b1b;
  border-radius: 10px;
  margin-top: 5px;
  margin-left: 5px;
}
</style>