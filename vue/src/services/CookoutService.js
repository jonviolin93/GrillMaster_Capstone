import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    listCookouts(){
        return http.get('/cookouts')
    },

    showCookoutDetails(id){
        return http.get(`/cookouts/${id}`)
    },

    createCookout(cookout){
        return http.post(`/cookouts`, cookout)
    },

    updateCookout(id, cookout){
        return http.put(`/cookouts/${id}`, cookout)
    },

    deleteCookout(id){
        return http.delete(`/cookouts/${id}`)
    }
}