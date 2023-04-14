<template>
  <div class="home">
    <header></header>
    <body>
      <section id="host">
        <h2 id="host-h2">HOST</h2>
        <div>
          <router-link to="/create-cookout">
            <button id="create-cookout-btn">Create Cookout</button>
          </router-link>
        </div>
        <cookout-list class="cookout-list"/>
      </section>
      <section id="attendee">
        <h2 id="attendee-h2">ATTENDEE</h2>
      </section>
      <section id="grill-master">
        <h2 id="grill-master-h2">GRILL MASTER</h2>
        <p>You must be authenticated to see this</p>
      </section>
    </body>
    <footer>
      <h4>Footer Text</h4>
    </footer>
  </div>
</template>

<script>
import CookoutList from "../components/CookoutList.vue";

export default {
  name: "home",
  components: {
    CookoutList,
  },
};
</script>
<style scoped>
.home {
  display: flex;
  flex-direction: column;
}

#host, #attendee, #grill-master {
  display: flex;
  justify-content: space-evenly;
  flex-direction: row;
  flex-wrap: wrap;
  height: 20vh;

  padding-top: 20px;
  padding-bottom: 20px;

  opacity: 0.65;
  background-color: orangered;
  border: 5px solid black;
}
#create-cookout-btn {
  flex-basis: 10%;
  margin-left: 5px;
}

#host-id, #attendee-id, #grill-master-id {
  flex-basis: 100%;
}

.cookout-list {
  flex-basis: 85%;
}

footer {
  background-image: url("../assets/Coals.png");
  display: flex;
  justify-content: space-evenly;
  flex-direction: row;
  flex-wrap: wrap;
  height: 15vh;

  padding-top: 20px;
  padding-bottom: 20px;
  border-left: 5px solid black;
  border-right: 5px solid black;
}
</style>
