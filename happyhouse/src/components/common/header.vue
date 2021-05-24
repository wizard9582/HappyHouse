<template>
	<div>
		<div class="row justify-content-center">
			<div class="col-xl-12">
				<div class="text-center text-white">
					<div style="float: left">
						<a class="navbar-brand" href="#!"
							><img :src="require('@/assets/ssafy.png')" alt="Ssafy logo"
						/></a>
					</div>
					<h1>HAPPY HOUSE -SSAFY Final Project-</h1>
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
						<input
							class="form-control"
							type="text"
							placeholder="지역 검색"
							aria-describedby="button-submit"
						/>
						<button class="btn btn-primary" id="button-submit" type="button">검색</button>
					</form>
				</div>
			</div>
		</div>
		<hr />
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
</style>
<script>
export default {};
</script>
