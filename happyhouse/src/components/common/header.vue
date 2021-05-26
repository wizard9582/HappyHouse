/* eslint-disable */
<template>
	<div>
		<div class="row" >
			<div class="col-xl-3 p-5" style="float: left">
				<a class="navbar-brand" href="/">
					<img :src="require('@/assets/logo.png')" alt="Ssafy logo" width="150" height="110"/>
				</a>
			</div>
			<div class="col-xl-6 text-center text-white">
				<br/><br/>
				<div id="mainTitle">HAPPY HOUSE -SSAFY Final Project-</div>
				<br/>
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="동 이름으로 바로 검색" aria-label="Recipient's username" aria-describedby="button-addon2" v-model="input" v-on:keyup.enter="sentenceSearch">
					<div class="input-group-append">
						<button class="btn btn-success" type="button" @click="sentenceSearch">검색</button>
					</div>
				</div>
				<div class="input-group mb-3">

					<b-form-select class="form-control nav-item" v-model="city" :options="cityOptions" @change="selectCity"></b-form-select>

					<b-form-select class="form-control nav-item" v-model="gugun" :options="gugunOptions" @change="selectGugun"></b-form-select>

					<b-form-select class="form-control nav-item" v-model="dong" :options="dongOptions"></b-form-select>

					<div class="input-group-append">
						<button class="btn btn-success" type="button" @click="formSearch">검색</button>
					</div>
				</div>
				<br/><br/><br/><br/><br/>
			</div>
			<div class="menuWrap col-xl-3 p-3 text-white" style="float: right">
				<ul class="nav justify-content-end">
					<li class="nav-item">
						<router-link to="/notice/list" class="nav-link text-white">공지사항</router-link></li>
					<li class="nav-item">
						<router-link to="/board/list" class="nav-link text-white">게시판</router-link></li>
					<li class="nav-item">
						<router-link to="/map/역삼동" class="nav-link text-white">지도</router-link></li>
					<li class="nav-item">
						<router-link to="/favorite" class="nav-link text-white">즐겨찾기</router-link></li>
					<li class="nav-item mr-5">
						<button v-if="!token" class="btn btn-primary" type="button" @click="$emit('tryLogin')">로그인</button>
						<button v-else class="btn btn-primary" type="button" @click="$emit('tryLogout')">로그아웃</button></li>
				</ul>
			</div>
			<hr />
		</div>
	</div>
</template>
<style scoped>
ul {
	list-style: none;
}
li {
	float: left;
}
.row {
	background: url('https://ifh.cc/g/sTLaVF.jpg');
	background-repeat: no-repeat !important;
	background-size: cover !important;
	background-position: center;
}
#mainTitle {
	display: block;
	font-size: 3.2em;
	margin-top: 0.5em;
	margin-bottom: 0.5em;
	margin-left: 0;
	margin-right: 0;
	font-weight: bold;
}
</style>
<script>
import rest from "@/js/httpCommon.js"
export default {
	props:["token"],
	data(){
		return{
			cityOptions:["도,광역시,특별시","서울특별시","경기도","인천광역시","부산광역시","인천광역시","대구광역시","울산광역시","세종특별자치시","광주광역시","강원도","충청북도","경상북도","경상남도","전라북도","전라남도"],
			gugunOptions:["시를 선택해주세요"],
			dongOptions:["구를 선택해주세요"],
			city : "",
			gugun : "",
			dong : "",
			input : ""
		}
	},
	created() {
		let getToken = localStorage.getItem("token")
		if(getToken){
			this.token = getToken
		}
	},
	methods: {
		sentenceSearch(){
			this.$router.push({
                path: "/map/" + this.input,
            });
		},
		formSearch(){
			this.$router.push({
                path: "/map/" + this.dong,
            });
		},
		selectCity(){
			//console.log("city!!");
			this.dongOptions = [];
			rest.axios({
				url:"/house/addrInfo/"+this.city,
				method: "get",
			})
				.then((res) => {
					//console.log(res.data);
					this.gugunOptions = res.data;
				})
				.catch(() => {
					alert("결과가 없습니다!");
				});
		},
		selectGugun(){
			//console.log("city!!");
			rest.axios({
				url:"/house/addrInfo/" + this.city + "/" + this.gugun,
				method: "get",
			})
				.then((res) => {
					//console.log(res.data);
					this.dongOptions = res.data;
				})
				.catch(() => {
					alert("결과가 없습니다!");
				});
		}
	},
};
</script>
