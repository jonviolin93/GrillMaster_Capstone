<template>
  <div id="background">
    <div id="headline">Create A New Cookout</div>
    <h1>New Cookout Form</h1>
    <form v-on:submit.prevent="submitCookout">
      <div class="transbox">
        <div class="form-input-cookout">
          <label for="cookout-name">Cookout Name</label>
          <input
            type="text"
            id="cookout-name"
            v-model="name"
            required
            autofocus
            style="align-self: flexbox-start"
          />
        </div>
        <!-- <div class="form-input-cookout">
    <label for="cookout-chef">Grill Master</label>
      <input
        type="text"
        id="cookout-chef"
        v-model = "cookout.attendees"
        required
      />
  </div> -->
        <div class="form-input-cookout">
          <label for="cookout-location">Location</label>
          <input
            type="text"
            id="cookout-location"
            v-model="location"
            required
          />
        </div>
        <div class="form-input-cookout">
          <label for="cookout-description">Description</label>
          <textarea
            id="cookout-description"
            rows="4"
            columns="60"
            v-model="description"
            required
          ></textarea>
        </div>
        <div class="form-input-cookout">
          <label for="cookout-date">Date</label>
          <input type="date" id="cookout-date" v-model="date" required />
        </div>
        <div class="form-input-cookout">
          <label for="cookout-time">Time</label>
          <input type="time" id="cookout-time" v-model="time" required />
        </div>
        <button
          type="submit"
          style="align-self: center"
          id="create-cookout-btn"
        >
          Create Cookout
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import CookoutService from "../services/CookoutService";
import MenuService from '../services/MenuService'
export default {
  data() {
    return {
      name: '',
      location: '',
      description: '',
      date: '',
      time: ''
    }
  },
  methods: {
    submitCookout() {
      let newMenuId;
      MenuService.addNewMenu().then(response => {
        newMenuId = response.data;
        const cookout = {
          name: this.name,
          location: this.location,
          description: this.description,
          date: this.date,
          time: this.time,
          menuId: newMenuId
        };
        CookoutService.createCookout(cookout).then(secondResponse => {
          if (secondResponse.status == 201)
            this.$router.push({name:'create-menu', params:{id:this.menuId}})
        }).catch(error => {
          if (error.response.status == 401) {
            ('Error submitting form. Log-in and try again.');
          }})
        }
      )
    }
  }
};
</script>

<style scoped>
form {
  display: flex;
  
  background-size: cover;
  align-items: left;
  justify-content: center;

  padding: 20vw;
}

h1 {
  font-weight: 300;
}

.transbox {
  display: flex;
  justify-content: center;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  padding-top: 20px;
  padding-bottom: 20px;
  padding-right: 20px;
border-radius: 10px;
  width: 60%;


  background-color: #BB2B1B;
  border: 5px solid black;
  font-weight: bold;
}
input#cookout-name,
#cookout-chef,
#cookout-location,
#cookout-description,
#cookout-date,
#cookout-time {
  background-color: rgb(231, 163, 15);
  border-radius: 10px;
}
textarea {
  margin-top: 5px;
}
button {
  background-color: black;
  color: white;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: bold;
  margin-top: 5px;
  border-radius: 10px;
}
div#headline {
  height: 120px;
  top: 0;
  bottom: 0;
  width:100%;
 
  border-radius: 10px;
  display: flex;
  background-image: url("../assets/Coals.png");
  background-size: cover;
 
align-items: center;
justify-content: center;
  font-weight: 600;
 position: relative;  
  font-size: calc(1rem + 1.8vh);
  line-height: 0.9;
  
}

label {
  display: inline-block;
  width: 150px;
  text-align: right;
  margin-right: 0.5rem;
}

input#cookout-time,
#cookout-date {
  margin-top: 5px;
}
h1{
   display: flex;
justify-content: center;
align-items: center;
  flex-direction: row;
  background-color: #BB2B1B;
  border-radius: 10px; 
width: 100%;
font-weight: bold;


}
</style>