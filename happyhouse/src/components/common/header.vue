<template>
	<div>
		<div class="row justify-content-center">
			<div class="col-xl-12">
				<div class="text-center">
					<div style="float: left">
						<a class="navbar-brand" href="/"
							><img :src="require('@/assets/ssafy.png')" alt="Ssafy logo"
						/></a>
					</div>
					<b><h1>HAPPY HOUSE -SSAFY Final Project-</h1></b>
					<div class="menuWrap">
						<ul class="menu">
							<li><router-link to="/notice">공지사항</router-link></li>
							<li><router-link to="/">게시판</router-link></li>
							<li><router-link to="/map/map">지도</router-link></li>
							<li><router-link to="/">더미</router-link></li>
							<li><router-link to="/">더미</router-link></li>
						</ul>
					</div>
				</div>
			</div>
			<hr />
		</div>
	</div>
</template>
<style scoped>
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
	border: 0;
	float: left;
}

/* Bordered form */
form {
	border: 3px solid #f1f1f1;
}

/* Full-width inputs */
input[type="text"],
input[type="password"] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	/*background-color: #04aa6d;*/
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
	opacity: 0.8;
}

/* Extra style for the cancel button (red) */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the avatar image inside this container */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

/* Avatar image */
img.avatar {
	width: 40%;
	border-radius: 50%;
}

/* Add padding to containers */
.container {
	padding: 16px;
}

/* The "Forgot password" text */
span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
<script>
export default {
	data() {
		return {
		};
	},
};
</script>
