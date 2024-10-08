import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css'
import axios from "axios";
import VueRouter from "vue-router";

Vue.config.productionTip = false
Vue.prototype.$axios=axios;
Vue.use(ElementUI);
Vue.use(VueRouter)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
