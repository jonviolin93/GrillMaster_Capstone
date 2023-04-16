import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getIndividualMenu(id){
        return http.get(`/menu/${id}`)
    },

    getFavoritedMenu(){
        return http.get('/menu/favorited')
    },

    addNewMenu(menu){
        return http.post(`/menu`, menu)
    }
}