<template>
	<div>
		<div class="row bg-secondary" >
			<div class="col-xl-3 p-5" style="float: left">
				<a class="navbar-brand" href="#!">
					<img :src="require('@/assets/logo.png')" alt="Ssafy logo" width="150" height="110"/>
				</a>
			</div>
			<div class="col-xl-6 text-center text-white">
				<br/><br/>
				<b><h1>HAPPY HOUSE -SSAFY Final Project-</h1></b>
				<br/>
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="시 / 구(군) / 동" aria-label="Recipient's username" aria-describedby="button-addon2">
					<div class="input-group-append">
						<button class="btn btn-success" type="button">검색</button>
					</div>
				</div>
				<div class="input-group mb-3">
						<select class="form-control nav-item" id="city" name="city">
							<option value="all" selected>시/도/광역시</option>
							<option value="서울특별시">서울특별시</option>
							<option value="경기도">경기도</option>
							<option value="인천광역시">인천광역시</option>
							<option value="부산광역시">부산광역시</option>
							<option value="대전광역시">대전광역시</option>
							<option value="대구광역시">대구광역시</option>
							<option value="울산광역시">울산광역시</option>
							<option value="세종특별자치시">세종시</option>
							<option value="광주광역시">광주광역시</option>
							<option value="강원도">강원도</option>
							<option value="충청북도">충청북도</option>
							<option value="경상북도">경상북도</option>
							<option value="경상남도">경상남도</option>
							<option value="전라북도">전라북도</option>
							<option value="전라남도">전라남도</option>
							<option value="제주특별자치도">제주도</option>
						</select> 
						<select class="form-control nav-item" id="gugun" name="gugun">
							<option value="all" selected>시를 선택해주세요</option>
						</select>
						<select class="form-control nav-item" id="dong" name="dong">
							<option value="all" selected>구를 선택해주세요</option>
						</select>
					<div class="input-group-append">
						<button class="btn btn-success" type="button">검색</button>
					</div>
				</div>
				<br/><br/><br/><br/><br/>
			</div>
			<div class="menuWrap col-xl-3 p-3 text-white" style="float: right">
				<ul class="nav justify-content-end">
					<li class="nav-item">
						<router-link to="/notice" class="nav-link text-white">공지사항</router-link></li>
					<li class="nav-item">
						<router-link to="/" class="nav-link text-white">게시판</router-link></li>
					<li class="nav-item">
						<router-link to="/map/map" class="nav-link text-white">지도</router-link></li>
					<li class="nav-item">
						<router-link to="/" class="nav-link text-white">즐겨찾기</router-link></li>
					<li class="nav-item mr-5">
						<button class="btn btn-primary" type="button">로그인</button></li>
				</ul>
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
