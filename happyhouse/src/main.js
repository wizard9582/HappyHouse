import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import Chartkick from "chartkick";
import VueChartkick from "vue-chartkick";
import VModal from "vue-js-modal";
import axios from "axios";

Vue.use(VModal, { dynamic: true });
Vue.use(VueChartkick, { Chartkick });
Vue.use(BootstrapVue);
Vue.config.productionTip = true;

new Vue({
	router,
	store,
	render: (h) => h(App),
}).$mount("#app");

export default {
	axios: axios.create({
		baseURL: "http://localhost:8080/",
		headers: {
			"Content-Type": "application/json",
		},
	}),
};
