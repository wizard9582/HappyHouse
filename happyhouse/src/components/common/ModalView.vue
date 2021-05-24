<template>
	<div class="modal">
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

<script>
export default {};
</script>

<style>
/* Modal */
.modal,
.overlay {
	width: 100%;
	height: 100%;
	position: fixed;
	left: 0;
	top: 0;
}
.overlay {
	opacity: 0.5;
	background-color: black;
}
.modal-card {
	position: relative;
	max-width: 80%;
	margin: auto;
	margin-top: 30px;
	padding: 20px;
	background-color: white;
	min-height: 500px;
	z-index: 10;
	opacity: 1;
}
</style>
