<template>
  <div class="card">
    <router-link :to="{ name: cookoutType, params: { id: cookout.id } }">
      <h2 class="cookout-name">{{ cookout.name }}</h2>
      <h4 class="cookout-date">{{ cookout.date }}</h4>
      <h4 class="cookout-time">{{ cookout.time }}</h4>
      <h4 class="cookout-location">{{ cookout.location }}</h4>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "cookout-card",
  props: ["cookout"],
  data() {
    return {
      currentUser: this.$store.state.user.username,
      attendees: this.cookout.attendees
    };
  },
  computed: {
    cookoutType() {
      let type;
      this.attendees.forEach((attendee) => {
        if (attendee.username == this.currentUser) {
          type = attendee.duty;
        }
      })
      return type;
    },
  },
};
</script>

<style>
.card {
  border: 2px solid rgb(231, 163, 15);
  border-radius: 10px;
  background: rgb(231, 163, 15);
  min-width: 200px;
  height: fit-content;
  margin: 10px;
  font-weight: 100;
}

.card .cookout-name {
  font-size: 1.5rem;
  font-weight: 400;
}

.cookout-date,
.cookout-time,
.cookout-location {
  font-size: 1rem;
  font-weight: 300;
}
</style>