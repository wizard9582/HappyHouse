/* eslint-disable */
<template>
	<div class="regist container">
		<h1>글 등록</h1>
		<div class="regist_form">
			<div class="mb-3">
				<label for="title">제목</label>
				<input class="form-control" type="text" id="title" v-model="board.title" ref="title" />
			</div>
			<div class="row">
				<div class="mb-3 col-6">
					<label for="apt">아파트 이름</label>
					<input class="form-control" type="text" id="apt" v-model="board.apt" ref="apt" />
				</div>

				<div class="mb-3 col-6">
					<label for="author">글쓴이</label>
					<input class="form-control" type="text" id="author" v-model="board.author" ref="author" />
				</div>
			</div>
			<div class="stars">
				<label for="als">종합</label>
				<input class="star star-5" id="allstar-5" type="radio" name="star" value="5" v-model="star.als"/>
				<label class="star star-5" for="allstar-5"></label>
				<input class="star star-4" id="allstar-4" type="radio" name="star" value="4" v-model="star.als"/>
				<label class="star star-4" for="allstar-4"></label>
				<input class="star star-3" id="allstar-3" type="radio" name="star" value="3" v-model="star.als"/>
				<label class="star star-3" for="allstar-3"></label>
				<input class="star star-2" id="allstar-2" type="radio" name="star" value="2" v-model="star.als"/>
				<label class="star star-2" for="allstar-2"></label>
				<input class="star star-1" id="allstar-1" type="radio" name="star" value="1" v-model="star.als"/>
				<label class="star star-1" for="allstar-1"></label>
			</div>
			<br />
			<div class="stars">
				<label for="sft">치안</label>
				<input class="star star-5" id="saftystar-5" type="radio" name="saftystar" value="5" v-model="star.sft"/>
				<label class="star star-5" for="saftystar-5"></label>
				<input class="star star-4" id="saftystar-4" type="radio" name="saftystar" value="4" v-model="star.sft"/>
				<label class="star star-4" for="saftystar-4"></label>
				<input class="star star-3" id="saftystar-3" type="radio" name="saftystar" value="3" v-model="star.sft"/>
				<label class="star star-3" for="saftystar-3"></label>
				<input class="star star-2" id="saftystar-2" type="radio" name="saftystar" value="2" v-model="star.sft"/>
				<label class="star star-2" for="saftystar-2"></label>
				<input class="star star-1" id="saftystar-1" type="radio" name="saftystar" value="1" v-model="star.sft"/>
				<label class="star star-1" for="saftystar-1"></label>
			</div>
			<br />
			<div class="stars">
				<label for="trf">교통</label>
				<input class="star star-5" id="trafficstar-5" type="radio" name="trafficstar" value="5" v-model="star.trf"/>
				<label class="star star-5" for="trafficstar-5"></label>
				<input class="star star-4" id="trafficstar-4" type="radio" name="trafficstar" value="4" v-model="star.trf"/>
				<label class="star star-4" for="trafficstar-4"></label>
				<input class="star star-3" id="trafficstar-3" type="radio" name="trafficstar" value="3" v-model="star.trf"/>
				<label class="star star-3" for="trafficstar-3"></label>
				<input class="star star-2" id="trafficstar-2" type="radio" name="trafficstar" value="2" v-model="star.trf"/>
				<label class="star star-2" for="trafficstar-2"></label>
				<input class="star star-1" id="trafficstar-1" type="radio" name="trafficstar" value="1" v-model="star.trf"/>
				<label class="star star-1" for="trafficstar-1"></label>
			</div>
			<br />
			<div class="stars">
				<label for="env">자연환경</label>
				<input class="star star-5" id="environstar-5" type="radio" name="environstar" value="5" v-model="star.env"/>
				<label class="star star-5" for="environstar-5"></label>
				<input class="star star-4" id="environstar-4" type="radio" name="environstar" value="4" v-model="star.env"/>
				<label class="star star-4" for="environstar-4"></label>
				<input class="star star-3" id="environstar-3" type="radio" name="environstar" value="3" v-model="star.env"/>
				<label class="star star-3" for="environstar-3"></label>
				<input class="star star-2" id="environstar-2" type="radio" name="environstar" value="2" v-model="star.env"/>
				<label class="star star-2" for="environstar-2"></label>
				<input class="star star-1" id="environstar-1" type="radio" name="environstar" value="1" v-model="star.env"/>
				<label class="star star-1" for="environstar-1"></label>
			</div>
			<br />
			<div class="stars">
				<label for="cvn">편의시설</label>
				<input class="star star-5" id="convstar-5" type="radio" name="convstar" value="5" v-model="star.cvn"/>
				<label class="star star-5" for="convstar-5"></label>
				<input class="star star-4" id="convstar-4" type="radio" name="convstar" value="4" v-model="star.cvn"/>
				<label class="star star-4" for="convstar-4"></label>
				<input class="star star-3" id="convstar-3" type="radio" name="convstar" value="3" v-model="star.cvn"/>
				<label class="star star-3" for="convstar-3"></label>
				<input class="star star-2" id="convstar-2" type="radio" name="convstar" value="2" v-model="star.cvn"/>
				<label class="star star-2" for="convstar-2"></label>
				<input class="star star-1" id="convstar-1" type="radio" name="convstar" value="1" v-model="star.cvn"/>
				<label class="star star-1" for="convstar-1"></label>
			</div>
			<br />
			<div class="stars">
				<label for="mng">관리</label>
				<input class="star star-5" id="managestar-5" type="radio" name="managestar" value="5" v-model="star.mng"/>
				<label class="star star-5" for="managestar-5"></label>
				<input class="star star-4" id="managestar-4" type="radio" name="managestar" value="4" v-model="star.mng"/>
				<label class="star star-4" for="managestar-4"></label>
				<input class="star star-3" id="managestar-3" type="radio" name="managestar" value="3" v-model="star.mng"/>
				<label class="star star-3" for="managestar-3"></label>
				<input class="star star-2" id="managestar-2" type="radio" name="managestar" value="2" v-model="star.mng" />
				<label class="star star-2" for="managestar-2"></label>
				<input class="star star-1" id="managestar-1" type="radio" name="managestar" value="1" v-model="star.mng"/>
					<label class="star star-1" for="managestar-1"></label>
			</div>
			<br />
			<div class="mb-3">
				<label for="date">date</label>
				<input class="form-control" type="date" id="date" v-model="board.date" ref="date" />
			</div>
			<div class="mb-3">
				<label for="content">본문</label>
				<textarea
					class="form-control"
					id="content"
					cols="50"
					rows="5"
					v-model="board.content"
					ref="content"
				></textarea>
				<br />
				<b-button @click="goList">목록으로</b-button>
				<b-button variant="success" @click="goWrite">등록</b-button>
				<b-button variant="danger" @click="goList">취소</b-button>
			</div>
		</div>
	</div>
</template>
<style scoped>
@import url(https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);
@import url(http://fonts.googleapis.com/css?family=Calibri:400,300,700);
@import url(https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css);
div.stars {
	width: 500px;
	display: inline-block;
}
input.star {
	display: none;
}

label.star {
	float: right;
	padding: 10px;
	font-size: 36px;
	color: #4a148c;
	transition: all 0.2s;
}

input.star:checked ~ label.star:before {
	content: "\f005";
	color: #fd4;
	transition: all 0.25s;
}

input.star-5:checked ~ label.star:before {
	color: #fe7;
	text-shadow: 0 0 20px #952;
}

input.star-1:checked ~ label.star:before {
	color: #f62;
}

label.star:hover {
	transform: rotate(-15deg) scale(1.3);
}

label.star:before {
	content: "\f006";
	font-family: FontAwesome;
}
</style>
<script>
import rest from "@/js/httpCommon.js";
export default {
	data() {
		return {
			board: {
				no: "",
				apt: "",
				title: "",
				author: "",
				date: "",
				content: "",
			},
			star: {
				no: "",
				als: "",
				sft: "",
				trf: "",
				env: "",
				cvn: "",
				mng: "",
			},
		};
	},
	created() {
		this.board.no = this.$route.params.no;
	},
	methods: {
		goWrite() {
			this.star.no = this.board.no;
			if (this.checkValidate()) {
				rest
					.axios({
						url: "/board/insert",
						method: "post",
						data: {
							star: this.star,
							board: this.board,
						}, //
					})
					.then((res) => {
						console.log(res);
						if (res.status === 200) {
							alert("리뷰 등록 성공");
							this.$router.push({
								path: "/board/list/",
							});
						} else {
							alert("리뷰 등록 실패");
						}
					})
					.catch(() => {
						alert("리뷰 등록 실패");
					});
			}
		},
		checkValidate() {
			let keys = ["no", "apt", "title", "author", "date", "content"];
			for (let key of keys) {
				if (!this.board[key]) {
					alert(key + " is empty");
					this.$refs[key].focus();
					return false;
				}
			}
			return true;
		},
		goList() {
			this.$router.push({
				path: "/board/list",
			});
			//console.log(noClicked);
		},
		changeManage(){

		}
	},
};
</script>
