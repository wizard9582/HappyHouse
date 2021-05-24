/* eslint-disable */

<template>
	<div id="app">
		<header-comp></header-comp>

		<router-view />

		<footer-comp></footer-comp>

		<modal name="demo-login" transition="pop-out" width="30%" :focus-trap="true" :height="400">
			<div class="input-group col-md-3">
				<form action="action_page.php" method="post">
					<div class="container">
						<label for="uname"><b>Username</b></label>
						<input type="text" placeholder="Enter Username" name="uname" required />

						<label for="psw"><b>Password</b></label>
						<input type="password" placeholder="Enter Password" name="psw" required />

						<button type="submit">Login</button>
						<label> <input type="checkbox" checked="checked" name="remember" /> Remember me </label>
					</div>

					<div class="container" style="background-color: #f1f1f1">
						<button type="button" class="cancelbtn">Cancel</button>
						<span class="psw">Forgot <a href="#">password?</a></span>
					</div>
				</form>
			</div>
		</modal>
	</div>
</template>

<style></style>
<script>
import FooterComp from "@/components/common/footer.vue";
import HeaderComp from "@/components/common/header.vue";
export default {
	components: {
		FooterComp,
		HeaderComp,
	},
	mounted() {
		this.$modal.hide('demo-login')
	},
	methods:{
		showLogin(){
			this.$modal.show('demo-login')
		}
	}
};
</script>
