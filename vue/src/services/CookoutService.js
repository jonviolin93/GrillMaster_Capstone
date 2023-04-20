import axios from "axios";



export default {
    listCookouts() {
        return axios.get('/cookouts')
    },

    showCookoutDetails(id) {
        return axios.get(`/cookouts/${id}`)
    },

    createCookout(cookout) {
        return axios.post('/cookouts/', cookout)
    },

    updateCookout(id, cookout) {
        return axios.put(`/cookouts/${id}`, cookout)
    },

    deleteCookout(id) {
        return axios.delete(`/cookouts/${id}`)
    },
    listCookoutsByAttending() {
        return axios.get('/cookouts/duty/3')

    },
    listCookoutsByHosting() {
        return axios.get('/cookouts/duty/1')
    },
    listCookoutsByGrillMaster() {
        return axios.get('/cookouts/duty/2')
    },
    listSearchedAttendees(searchTerm) {
        return axios.get(`/cookouts/user-search?searchTerm=${searchTerm}`)
    },
    addAttendeesToCookout(id, cookout) {
        return axios.put(`/cookouts/${id}`, cookout)
    }
}