<template>
  <div>
      <router-link v-for="cookout in cookoutTypeList" v-bind:key="cookout.id" to="{name: host}">
        <cookout-card v-bind:cookout="cookout"/>
      </router-link>
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

a {
  background-color: transparent;
  text-decoration: none;
}

</style>