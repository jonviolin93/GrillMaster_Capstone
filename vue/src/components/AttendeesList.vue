<template>
  <div class="attendees">
    <label id="header"><h2>Attendees</h2></label>
    
    <div><h3 id="g1">Name</h3></div> 
    <div><h3 id="g2">Role</h3></div>
    <div v-for="attendee in attendees" v-bind:key="attendee.id">
      <h3 id="g3">{{ attendee.name }}</h3>
    </div>
    <div v-for="attendee in attendees" v-bind:key="attendee.id">
      <h3 id="g4">{{ attendee.duty }}</h3>
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

#g1, #g2, #g4 {
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
  font-weight: 200;
}
#g3 {
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
  font-weight: 200;
}
</style>