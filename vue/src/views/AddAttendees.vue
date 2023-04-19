<template>
  <div>
      <form v-on:submit="findUsersBySearch">
          <label for="search"></label>
          <input type="text" name="search" id="search" > //add search connection
      </form>
  </div>
</template>

<script>
import CookoutService from '../services/CookoutService'
export default {
    data() {
        return {
            search: ''
        }
    },
    methods: {
        findUsersBySearch() {
            CookoutService.listSearchedAttendees()
        }
    }
}
</script>

<style>

</style>