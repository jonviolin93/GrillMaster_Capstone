<template>
  <div>
    <div class="header">
      <p id="header-text">Create A New Cookout</p>
    </div>
    <div>
      <h1>New Cookout Form</h1>
    </div>
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
          <label id="label-desc" for="cookout-description">Description</label>
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
import MenuService from "../services/MenuService";
export default {
  data() {
    return {
      name: "",
      location: "",
      description: "",
      date: "",
      time: "",
    };
  },
  methods: {
    submitCookout() {
      let newMenuId;
      MenuService.addNewMenu().then((response) => {
        newMenuId = response.data;
        console.log(newMenuId)
        const cookout = {
          name: this.name,
          location: this.location,
          description: this.description,
          date: this.date,
          time: this.time,
          menuId: newMenuId,
        };
        CookoutService.createCookout(cookout).then(secondResponse => {
          if (secondResponse.status == 201)
          console.log('menu id: ' + cookout.menuId);
            this.$router.push({name:'create-menu', params:{cookoutId:secondResponse.data, menuId:cookout.menuId}})
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

h1 {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row;
  background-color: #bb2b1b;
  border-radius: 10px;
  width: 100%;
}

form {
  display: flex;
  background-size: cover;
  align-items: left;
  justify-content: center;
  padding: 5px;
}

label {
  vertical-align: middle;
  display: inline-block;
  width: 150px;
  text-align: right;
  margin-right: 0.5rem;
  font-weight: 200;
}

#label-desc{
  vertical-align: top;
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
  background-color: #bb2b1b;
  border: 5px solid black;
  font-weight: bold;
}

#cookout-name,
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
  font-weight: 300;
  margin-top: 5px;
  border-radius: 10px;
  background-color: rgb(231, 163, 15);
  margin-left: 10rem;
}

button:hover{
  background-color: #bb2b1b;
}

#cookout-time,
#cookout-date {
  margin-top: 5px;
}
</style>