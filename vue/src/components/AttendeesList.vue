<template>
  <div>
  <div class="attendees" v-for="attendee in attendees" v-bind:key="attendee.id">
    <label for="attendee-name">Name</label>
    <h2 class="attendee-name">{{ attendee.name }}</h2>
    <label id="g2" for="attendee-duty">Role</label>
    <h2 id="g4" class="attendee-duty">{{ attendee.duty }}</h2>
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
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
    "g1 g3"
    "g2 g4"; 
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
}
#g3 {
  grid-area: g3;
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px; 
  margin: 5px;
}
#g4 {
  grid-area: g4;
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px; 
  margin: 5px;
}
</style>