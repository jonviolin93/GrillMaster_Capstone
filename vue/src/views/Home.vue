<template>
  <div class="home">
    <header></header>
    <body>
      <div>
        <router-link id="create-cookout-link" to="/create-cookout">
          <p id="create-cookout-text">Create Cookout</p>
        </router-link>
      </div>
      <div class="lists">
        <section id="host">
          <h2 id="host-h2">HOSTING</h2>
          <cookout-list class="cookout-list" id="host-list" v-bind:cookout-type-list="$store.state.hostedCookouts"/>
        </section>
        <section id="attendee">
          <h2 id="attendee-h2">ATTENDING</h2>
          <cookout-list class="cookout-list" id="attendee-list" v-bind:cookout-type-list="$store.state.attendCookouts"/>
        </section>
        <section id="grill-master">
          <h2 id="grill-master-h2">GRILL<br>MASTER</h2>
        <cookout-list class="cookout-list" id="grillmaster-list" v-bind:cookout-type-list="$store.state.grillmasterCookouts"/>
        </section>
      </div>
    </body>
    <footer>
      <h4>Cookout App created by The GrillMasterz: Meli, Red, Cameron, Ellis, and Jonathan</h4>
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
  created() {
    this.$store.dispatch('listHost');
    this.$store.dispatch('listAttending');
    this.$store.dispatch('listGrillMaster');
    },
  };
</script>
<style scoped>
.home {
  display: flex;
  flex-direction: column;
}
.lists {
  display: flex;
  flex-direction: column;
}

#host {
  border-radius: 15px 15px 0 0;
}

#grill-master {
  border-radius: 0 0 15px 15px;
}

#host, #attendee, #grill-master {
  display: flex;
  justify-content: flex-start;
  
  flex-direction: row;                  
  
  background-color: #BB2B1B;
  border: 5px solid black;
}

#create-cookout-link {
  position: relative; 
  width: 70%;
  display: flex;
  align-items: center;
  justify-content: center;
  left: 15%;
  right: 15%;
}

#create-cookout-link:hover{
  background-color: transparent;
}

#create-cookout-link:hover:before{
  opacity: 0.5;
}

#create-cookout-link:before {
  content: "";
  background-size:cover;
  position: absolute;
  top: 0;
  bottom: 0;
  width:100%;
  opacity: 0.66;
  border-radius: 10px;
  display: inline-block;
  background-image: url("../assets/Coals.png");
  padding: 0 20px;
}

#create-cookout-text {
  position: relative;  
  font-size: calc(1rem + 1.8vh);
  line-height: 0.9;
}


#host-h2, #attendee-h2, #grill-master-h2 {
  display: block;
  width: 100%; 
  align-self: center;
  flex: 0 0 150px;
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

@media(min-width: 769px){
  /* width */
::-webkit-scrollbar {
  width: 15px;
}

/* Track */
::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px rgb(241, 32, 32); 
  border-radius: 10px;
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: red; 
  border-radius: 10px;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #b30000; 
}
}

@media(max-width: 425px) {
  #host, #attendee, #grill-master {
    flex-direction: column;
  }

  #host-h2, #attendee-h2, #grill-master-h2 {
  align-self: center;
  flex: 0 0 0;
  }

  #create-cookout-link:before{
    opacity: 0.5;
  }
}
</style>
