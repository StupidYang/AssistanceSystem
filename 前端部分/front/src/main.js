import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Axios from "axios";
import VueAxios from "vue-axios";
import Vuex from "vuex";
import Qs from 'qs';
import modules from './store/store-modules'

Vue.config.productionTip = false

Vue.use(ElementUI)
Vue.use(VueAxios,Axios)
Vue.use(Qs)
Vue.use(Vuex)

Axios.defaults.baseURL = 'http://localhost:8080'
Axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
Axios.defaults.withCredentials = true


const store = new Vuex.Store({
  modules:modules
})

new Vue({
  render: h => h(App),
  store:store,
  router:router
}).$mount('#app')
