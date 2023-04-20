<template>
  <div class="cookout-details">
    <label id="g1" for="cookout-name">Name</label>
    <h2 id="g6" class="cookout-name">{{ cookout.name }}</h2>
    <label id="g2" for="cookout-date">Date</label>
    <h4 id="g7" class="cookout-date">{{ cookout.date }}</h4>
    <label id="g3" for="cookout-time">Time</label>
    <h4 id="g8" class="cookout-time">{{ cookout.time }}</h4>
    <label id="g4" for="cookout-location">Location</label>
    <h4 id="g9" class="cookout-location">{{ cookout.location }}</h4>
    <label id="g5" for="cookout-description">Description</label>
    <p id="g10" class="cookout-description">{{ cookout.description }}</p>
  </div>
</template>

<script>
export default {
  name: "cookout-details",
  props: {
    cookout: Object,
  },
};
</script>
<style scoped>
.cookout-details {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    "g1 g2 g3 g4"
    "g6 g7 g8 g9"
    "g6 g5 g5 g5"
    "g6 g10 g10 g10";
}

#g1,
#g2,
#g3,
#g4,
#g5,
#g6,
#g7,
#g8,
#g9,
#g10 {
  overflow-wrap: break-word;
  line-height: 1.5;
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

#g5 {
  grid-area: g5;
  background-color: rgb(231, 163, 15);
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
}

#g6 {
  grid-area: g6;
  margin: 5px;
  font-weight: 400;
}

#g7 {
  grid-area: g7;
}

#g8 {
  grid-area: g8;
}

#g9 {
  grid-area: g9;
  overflow-wrap: break-word;
  line-height: 1.5;
}

#g10 {
  grid-area: g10;
}
</style>
