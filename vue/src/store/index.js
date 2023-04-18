import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import CookoutService from '../services/CookoutService'
import MenuService from '../services/MenuService'


Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    hostedCookouts:[
      {
        id: "",
        name: "",
        date: "",
        time: "",
        location: "",
        description: "",
        attendeesList: [],
        menuId: ""
      }
    ],
    grillmasterCookouts:[
      {
        id: "",
        name: "",
        date: "",
        time: "",
        location: "",
        description: "",
        attendeesList: [],
        menuId: ""
      }
    ],
    attendCookouts:[
      {
        id: "",
        name: "",
        date: "",
        time: "",
        location: "",
        description: "",
        attendeesList: [],
        menuId: ""
      }
    ],
    menuItems:[
      {
      id: "",
      name: "",
      isFavorited: false,
      foodList: [],
    }
    ],
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    LIST_HOST_COOKOUTS(state, payload){
    state.hostedCookouts = payload;
    },
    LIST_GRILLMASTER_COOKOUTS(state, payload){
    state.grillmasterCookouts = payload;
    },
    LIST_ATTENDEE_COOKOUTS(state, payload){
    state.attendCookouts = payload;
    },
    LIST_MENU_ITEMS(state, payload){
    state.menuItems = payload;  
    },
  },
  actions: {
    async listHost({ commit }) {
      let data = await CookoutService.listCookoutsByHosting();
      commit('LIST_HOST_COOKOUTS', data.data)
    },
    async listAttending({ commit }) {
      let data = await CookoutService.listCookoutsByAttending();
      commit('LIST_ATTENDEE_COOKOUTS', data.data)
    },
    async listGrillMaster({ commit }) {
      let data = await CookoutService.listCookoutsByGrillMaster();
      commit('LIST_GRILLMASTER_COOKOUTS', data.data)
    },
    async listMenu({ commit, id }) {
      let data = await MenuService.getIndividualMenu(id);
      commit('LIST_MENU_ITEMS', data.data)
    }
  }

  }
)
