<template>
<div id="background">
  <div id="headline">Create A New Cookout</div>
  <form @submit="button">

  <div class="transbox">
  <div class="form-input-cookout">
          <label for="cookout-name">Cookout Name</label>
          <input
            type="text"
            id="cookout-name"
        
            required
            autofocus
            style="align-self: flexbox-start"
          />
        </div>
        <div class="form-input-cookout">
          <label for="cookout-chef">Grill Master</label>
          <input
            type="text"
            id="cookout-chef"
          
            required
          />
        </div>
        <div class="form-input-cookout">
          <label for="cookout-location">Location</label>
          <input
            type="text"
            id="cookout-location"
           
            required
          />
          </div>
          <div class="form-input-cookout">
          <label for="cookout-description">Description</label>
          <textarea 
            id="cookout-description"
           rows="4"
           columns="60"
            required
          ></textarea>
          </div>
            <div class="form-input-cookout">
          <label for="cookout-date">Date</label>
          <input
            type="date"
            id="cookout-date"
           
            required
          />
          </div>
            <div class="form-input-cookout">
          <label for="cookout-time">Time</label>
          <input
            type="time"
            id="cookout-time"
           
            required
          />
          </div>
          <button type="submit" style="align-self: center" id="create-cookout-btn">Create Cookout</button>
        </div>
        <add-cookout/>
        </form>
        </div>
        
</template>

<script>
import AddCookout from "../components/AddCookout.vue";
export default {
  components: {
    AddCookout,
  },
};
</script>

<style>

form{
  display: flex;
  background-image: url("../assets/Coals.png");
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

  width: 60%;

  opacity: 0.65;
  background-color: orangered;
  border: 5px solid black;
}
input#cookout-name, #cookout-chef, #cookout-location, #cookout-description, #cookout-date, #cookout-time {
  background-color: orange;

 
}
textarea{
margin-top: 5px;
}
button{
background-color: black ;
color: white;
font-family: "Kanit", Arial, Helvetica, sans-serif;
font-weight: bold;
margin-top: 5px;
}
div#headline{
  display: flex;
  background-color: black;
  color: orange;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  font-weight: 600;
  font-size: 40px;
  align-items: center;
  justify-content: center;
}

label {
  display: inline-block;
  width: 150px;
  text-align: right;
  margin-right: 0.5rem;
  

}

input#cookout-time, #cookout-date{
  margin-top: 5px;
}
</style>