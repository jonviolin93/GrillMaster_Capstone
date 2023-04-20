<template>
  <div id="column">
       <div class="header">
      <p id="header-text">Add Attendees</p>
    </div>
    <div id="form-box">
      <form v-on:submit.prevent="findUsersBySearch">
          <label for="search">Search by username:</label>
          <input type="text" name="search" id="search" v-model="search">
          <input id="search-button" type="submit" value="Search" />
      </form>
      <ul>
          <li v-for="user in cookout.attendees" v-bind:key="user.user_id">{{user.username}}, {{user.duty}}</li>
      </ul>
      <form v-on:submit.prevent="addAttendeeList">
      <div id="users" v-for="user in this.returnedUsers" v-bind:key="user.id">
          <input type="checkbox" :value=user v-model="cookout.attendees" v-on:click="usersAdded = false"/>
          <p>{{user.username}}</p>
          <select name="duty" id="duty" v-model="user.duty">
              <option value="Grill Master">Grill Master</option>
              <option value="Attendee">Attendee</option>
          </select>
       </div>
       <input id="submit-list" type="submit" value="Submit Attendees" />
      
      </form>
    </div>
    <p v-if="usersAdded">Users successfully invited</p>
    <router-link :to="{name: 'home'}" v-if="usersAdded">Home</router-link>
  </div>
</template>

<script>
import CookoutService from '../services/CookoutService'
export default {
    data() {
        return {
            search: '',
            returnedUsers: [],
            selectedUsers: [],
            cookout: {},
            usersAdded: false
        }
    },
    created() {
        CookoutService.showCookoutDetails(this.$route.params.id)
        .then(response => {
            this.cookout = response.data;
        })

    },
    methods: {
        findUsersBySearch() {
            CookoutService.listSearchedAttendees(this.search)
            .then(response => {
                this.returnedUsers = response.data;
            })
        },
        // compareUsers(user){
        //     let userInList = false;
        //     this.cookout.attendees.forEach(attendee => {
        //         if (attendee.username == user.username){
        //             userInList = true;
        //         }
        //     })
        //     return userInList
        // },
        addAttendeeList() {
            this.cookout.attendees.forEach(attendee => delete attendee.authorities)
            CookoutService.addAttendeesToCookout(this.$route.params.id, this.cookout)
            .then(response => {
                if (response.status == 200){
                    this.usersAdded = true;
                }
            });
        }           
    }
}
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
#submit-list{
    background-color: #bb2b1b;
    color: white;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  border-radius: 10px;
  margin-top:10%;
}
#form-box{
    display: flex;
    background-color: rgb(231, 163, 15);
    flex-direction: column;
    border-radius: 10px;
   
    justify-content: center;
    align-items: center;
    margin-left: 10%;
    margin-right: 10%;
    margin-top:5%;
    padding:5%;
    
} 
users{
    display: flex;
    flex-direction: column;
   
}
#duty{
    border-radius: 10px;
    background-color: #bb2b1b;
    color: white;
    font-family: "Kanit", Arial, Helvetica, sans-serif;
     margin-bottom: 5%;
}
#column{
    display: flex;
    flex-direction: column;
  
    justify-content: center;
}
#search{
    border-radius: 10px;

}
#search-button{
    background-color: #bb2b1b;
    color: white;
  font-family: "Kanit", Arial, Helvetica, sans-serif;
  border-radius: 10px;
}



</style>