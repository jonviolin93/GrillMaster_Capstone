import axios from "axios";



export default {
    getIndividualMenu(id){
        return axios.get(`/menu/${id}`)
    },

    getFavoritedMenu(){
        return axios.get('/menu/favorited')
    },

    addNewMenu(){
        return axios.post('/menu/', {name: ''})
    }
}