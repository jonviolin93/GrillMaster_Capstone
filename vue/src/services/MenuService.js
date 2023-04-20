import axios from "axios";



export default {
    getIndividualMenu(id) {
        return axios.get(`/menu/${id}`)
    },

    getFavoritedMenu() {
        return axios.get('/menu/favorited')
    },

    addNewMenu() {
        return axios.post('/menu/', { name: '' })
    },

    searchFoods(ingredient, restriction, category) {
        if (ingredient != '') {
            ingredient = "ingr=" + ingredient + "&";
        }
        if (restriction != '') {
            restriction = "health=" + restriction + "&";
        }
        if (category != '') {
            category = "category=" + category;
        }
        return axios.get(`/food?${ingredient}${restriction}${category}`)
    },

    addFoodToDatabase(food) {
        return axios.post('/food', food)
    },

    updateMenu(id, menu) {
        return axios.put(`/menu/${id}`, menu)
    }
}