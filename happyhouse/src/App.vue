/* eslint-disable */

<template>
	<div id="app">
		<header-comp @tryLogin="openLogin" @tryLogout="Logout" v-bind:token="token"></header-comp>

		<router-view :key="$route.fullPath"/>

		<footer-comp></footer-comp>
		<login-modal v-if="showLoginModal" @tryLogin="Login" @tryRegist="openRegist" @close="closeLogin"></login-modal>
		<regist-modal v-if="showRegistModal" @tryRegist="Regist" @close="closeRegist"></regist-modal>
	</div>
</template>
<style>

.modal-mask {
	position: fixed;
	z-index: 9998;	
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, .5);
	display: table;
	transition: opacity .3s ease;
}

.modal-wrapper {
	display: table-cell;
	vertical-align: middle;
}

.modal-container {
	width: 300px;
	margin: 0px auto;
	padding: 20px 30px;
	background-color: #fff;
	border-radius: 2px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
	transition: all .3s ease;
	font-family: Helvetica, Arial, sans-serif;
}

.modal-header h3 {
	margin-top: 0;
	color: #42b983;
}

.modal-body {
	margin: 20px 0;
}

.modal-default-button {
	float: right;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
	opacity: 0;
}

.modal-leave-active {
	opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
-webkit-transform: scale(1.1);
	transform: scale(1.1);
}
</style>

<script>
import FooterComp from "@/components/common/footer.vue";
import HeaderComp from "@/components/common/header.vue";
import LoginModal from "@/components/common/loginmodal.vue";
import RegistModal from "@/components/common/registmodal.vue";
import rest from "@/js/httpCommon.js"
export default {
	data(){
		return{
			showLoginModal : false,
			showRegistModal : false,
			token : ""
		}
	},
	components: {
		FooterComp,
		HeaderComp,
		LoginModal,
		RegistModal
	},
	methods:{
		Login(user){
			//console.log(user);
			rest.axios({
				url:"/user/login",
				method: "post",
				data: user, //
			})
				.then((res) => {
					console.log(res);
					if (res.data.status == true) {
						this.token = res.data.token;
						//console.log(this.token);
						localStorage.setItem('token', this.token);
						localStorage.setItem('id', user.id);
						alert("로그인 성공");
						this.closeLogin();
					} else {
						alert("로그인 실패");
					}
				})
				.catch(() => {
					alert("로그인 실패");
				});

		},
		Logout(){
			this.token = "";
			localStorage.clear();
		},
		Regist(user){
			//console.log(user);
			rest.axios({
				url:"/user/signup",
				method: "post",
				data: user, //
			})
				.then((res) => {
					console.log(res);
					if (res.data == 200) {
						//console.log(this.token);
						alert("가입 성공");
						this.openLogin();
					} else {
						alert("가입 실패");
					}
				})
				.catch(() => {
					alert("가입 실패");
				});
		},
		openLogin(){
			this.showLoginModal  = true;
			this.showRegistModal = false;
		},
		openRegist(){
			this.showLoginModal  = false;
			this.showRegistModal = true;
		},
		closeLogin(){
			this.showLoginModal  = false;
		},
		closeRegist(){
			this.showRegistModal = false;
		}
	}
};
</script>
