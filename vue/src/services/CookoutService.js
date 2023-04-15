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

    createCookout(){
        return http.post('/cookouts')
    },

    updateCookout(id){
        return http.put(`/cookouts/${id}`)
    },

    deleteCookout(id){
        return http.delete(`/cookouts/${id}`)
    }
}