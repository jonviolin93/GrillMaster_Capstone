import axios from "axios";


export default{
completeOrder(id){
return axios.put(`cookouts/1/order/${id}`)
}
}