import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import CreateCookout from '../views/CreateCookout.vue'
import MenuCreate from '../views/MenuCreate.vue'
import AddAttendees from '../views/AddAttendees.vue'

import ChefShortOrder from '../views/ChefShortOrder.vue'
import Host from '../views/Host.vue'
import Attendee from '../views/Attendee.vue'
Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/create-cookout",
      name: "create-cookout",
      component: CreateCookout,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/:cookoutId/:menuId/create-menu",
      name: "create-menu",
      component: MenuCreate,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/cookouts/:id/short-order",
      name: "Grill Master",
      component: ChefShortOrder,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/cookouts/:id/host",
      name: "Host",
      component: Host,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/cookouts/:id/attendee",
      name: "Attendee",
      component: Attendee,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/:id/add-attendees",
      name: "add-attendees",
      component: AddAttendees,
      meta: {
        requiresAuth: true
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    next();
  }
});

export default router;
