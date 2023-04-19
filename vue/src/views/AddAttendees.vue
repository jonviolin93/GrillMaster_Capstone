<template>
  <div>
      <form v-on:submit.prevent="findUsersBySearch">
          <label for="search">Search by username:</label>
          <input type="text" name="search" id="search" v-model="search">
          <input type="submit" value="Search" />
      </form>
      <ul>
          <li v-for="user in selectedUsers" v-bind:key="user.user_id">{{user.username}}, {{user.duty}}</li>
      </ul>
      <form v-on:submit.prevent="s">
      <div v-for="user in this.returnedUsers" v-bind:key="user.id">
          <input type="checkbox" :value=user v-model="selectedUsers"/>
          {{user.username}}
          <select name="duty" id="duty" v-model="user.duty">
              <option value="Grill Master">Grill Master</option>
              <option value="Attendee">Attendee</option>
          </select>
       </div>
       <input type="submit" value="Submit attendee list" />
      </form>
  </div>
</template>

<script>
import CookoutService from '../services/CookoutService'
export default {
    data() {
        return {
            search: '',
            returnedUsers: [],
            selectedUsers: []
        }
    },
    methods: {
        findUsersBySearch() {
            CookoutService.listSearchedAttendees(this.search)
            .then(response => {
                this.returnedUsers = response.data;
            })
        },
        addAttendeeList() {
            CookoutService.addAttendeesToCookout()
        }
    }
}
</script>

<style>

</style>