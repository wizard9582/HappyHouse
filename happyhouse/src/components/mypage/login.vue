<template>
<modal name="demo-login" transition="pop-out" width="modalWidth" :focus-trap="true" :height="400">
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

			<form>
				<input
					class="form-control"
					type="text"
					placeholder="지역 검색"
					aria-describedby="button-submit"
				/>
				<button class="btn btn-primary" id="button-submit" type="button">검색</button>
				<input class="btn btn-default col-md-3" @click="$emit('close')" type="button" value="취소">
			</form>
		</div>
</modal>
</template>
<style scoped></style>
<script>
export default {
	name: "demo-login",
};
</script>
