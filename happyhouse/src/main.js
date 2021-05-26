import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import VModal from 'vue-js-modal'
import Chartkick from 'vue-chartkick'
import Chart from 'chart.js'

Vue.use(VModal, { dynamic: true })
Vue.use(Chartkick.use(Chart))
Vue.use(BootstrapVue);
Vue.config.productionTip = true;

new Vue({
	router,
	store,
	render: (h) => h(App),
}).$mount("#app");
