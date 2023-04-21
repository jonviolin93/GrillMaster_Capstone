<template>
  <div class="attendees">
    <label id="header"><h2>Attendees</h2></label>
    <div
      v-for="attendee in attendees"
      v-bind:key="attendee.id"
      id="list-of-attendees"
    >
      <h3 id="g3">{{ attendee.duty }}</h3>
      <h3 id="g4">{{ attendee.username }}</h3>
    </div>
  </div>
</template>

<script>
export default {
  name: "attendees-list",
  props: {
    attendees: Object,
  },
};
</script>

<style scoped>
.attendees {
  display: grid;
  grid-auto-columns: 1fr;
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

#g3 {
  border: 2px solid black;
  border-radius: 5px;
  font-weight: 200;
  background-color: rgb(231, 163, 15);
}

#g4 {
  border-radius: 5px;
  font-weight: 200;
  background-color: transparent;
  border-color: transparent;
}
</style>