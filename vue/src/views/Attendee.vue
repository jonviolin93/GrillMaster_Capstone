<template>
  <div>
    <div class="header">
      <p id="header-text">Attendee</p>
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
import CookoutDetailsComp from "../components/CookoutDetailsComp.vue";
import AttendeesList from "../components/AttendeesList.vue"
import MenuItems from "../components/MenuItems.vue";

export default {
  name: "attendee",
  components: { CookoutDetailsComp, MenuItems, AttendeesList},
  computed: {
    getCookoutDetails() {
      let oneCookoutDetails = this.$store.state.attendCookouts.find((item) => {
        return item.id == this.$route.params.id;
      });
      return oneCookoutDetails;
    },

    getAttendeeList() {
      let attendeeList = this.$store.state.attendCookouts.find((item) => {
        return item.id == this.$route.params.id;
      });
      return attendeeList.attendees;
    },
  },

  created() {
    const cookoutId = this.$route.params.id;
    let menuId;
    this.$store.state.attendCookouts.forEach((cookout) => {
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
  grid-auto-flow: column;
  grid-auto-columns: 1fr;
  gap: .5em
}

#menu-details {
  background-color: #bb2b1b;
  border-radius: 10px;
  margin-top: 5px;
  margin-right: 5px;
  width: 1fr;
}

#attendees-list {
  background-color: #bb2b1b;
  border-radius: 10px;
  margin-top: 5px;
  margin-left: 5px;
  width: 1fr;
}

@media (min-width: 769px) {
  /* width */
  #flexbox {
    grid-auto-flow: column;
    grid-auto-columns: 1fr;
  }
}
@media (max-width: 35em) {
  #flexbox {
    grid-auto-flow: column;
    grid-auto-columns: 1fr;
  }
}
</style>