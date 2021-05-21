<template>
	<header class="container position-relative bg-dark">
		<div class="row justify-content-center">
			<div class="col-xl-12">
				<div class="text-center text-white">
					<nav class="navbar navbar-light bg-light static-top">
						<div class="container">
							<a class="navbar-brand" href="#!">Start Bootstrap</a>
							<a class="btn btn-primary" href="#signup">Sign Up</a>
						</div>
					</nav>
					<h1>HAPPY HOUSE  -SSAFY Final Project-</h1>
					    <div class="menuWrap">
							<ul class="menu">
								<li><router-link to="/">공지사항</router-link></li>
								<li><router-link to="/">게시판</router-link></li>
								<li><router-link to="/">지도</router-link></li>
								<li><router-link to="/">더미</router-link></li>
								<li><router-link to="/">더미</router-link></li>
							</ul>
						</div>
					<form>
						<div class="input-group input-group-lg ">
							<input class="form-control" type="text" placeholder="지역 검색" aria-describedby="button-submit" />
							<button class="btn btn-primary" id="button-submit" type="button">검색</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<hr>
	</header>
</template>
<style scoped>
header{width:100%; text-align:center; position:relative; height:120px; border-bottom:1px solid #35495e}
header ul.menu:after{display:block; clear:both; content:'';}
header ul.menu{position:relative; top:20px; right:50px;}
header ul.menu li{float:left; padding:10px 20px; list-style:none;}
a{text-decoration:none; color: azure;}
</style>
<script>
export default {};
</script>
