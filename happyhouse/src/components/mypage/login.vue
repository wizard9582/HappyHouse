<template>
	<div>
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
		</form>
	</div>
</template>
<style scoped></style>
<script>
export default {
	name: "Content",
};
</script>
