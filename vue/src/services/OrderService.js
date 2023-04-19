import axios from "axios";


export default{
completeOrder(id){
return axios.put(`cookouts/1/order/${id}`)
},

placeOrder(cookoutId, order) {
    return axios.post(`cookouts/${cookoutId}/order/`, order);
}
}