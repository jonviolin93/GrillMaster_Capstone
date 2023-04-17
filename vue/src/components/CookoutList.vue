<template>
  <div>
    
      <cookout-card v-for="cookout in cookoutTypeList" v-bind:key="cookout.id"  v-bind:cookout="cookout"/>
  
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

<style>

</style>