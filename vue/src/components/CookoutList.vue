<template>
  <div class="cookout-list">
        <cookout-card id="cookout-card" v-for="cookout in cookoutTypeList" v-bind:key="cookout.id" v-bind:cookout="cookout"/>
  </div>
</template>

<script>
import CookoutCard from '../components/CookoutCard.vue';
export default {
name: "list-of-cookouts",
components:{
  CookoutCard
},
props:[
  "cookoutTypeList"
]
  
}
</script>

<style scoped>
.cookout-list{
  flex: 1;
  display: flex;
  overflow-x: auto;
}

/* #cookout-card{
  flex-grow: 200px;
  width: 200px;
} */

a {
  background-color: transparent;
  text-decoration: none;
}

</style>