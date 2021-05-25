/* eslint-disable */
<template>
	<div class="regist container">
		<h1>글 등록</h1>
		<div class="regist_form">
			<div class="mb-3">
				<label for="title">title</label>
				<input class="form-control" type="text" id="title" v-model="board.title" ref="title" />
			</div>
			<div class="mb-3">
				<label for="apt">apt</label>
				<input class="form-control" type="text" id="apt" v-model="board.apt" ref="apt" />
			</div>

			<div class="mb-3">
				<label for="author">author</label>
				<input class="form-control" type="text" id="author" v-model="board.author" ref="author" />
			</div>
			<div class="mb-3">
				<label for="als">star_als</label>
				<input class="form-control" type="text" id="als" v-model="star.als" ref="als" />
			</div>
			<div class="mb-3">
				<label for="sft">star_sft</label>
				<input class="form-control" type="text" id="sft" v-model="star.sft" ref="sft" />
			</div>
			<div class="mb-3">
				<label for="trf">star_trf</label>
				<input class="form-control" type="text" id="trf" v-model="star.trf" ref="trf" />
			</div>
			<div class="mb-3">
				<label for="env">star_env</label>
				<input class="form-control" type="text" id="env" v-model="star.env" ref="env" />
			</div>
			<div class="mb-3">
				<label for="cvn">star_cvn</label>
				<input class="form-control" type="text" id="cvn" v-model="star.cvn" ref="cvn" />
			</div>
			<div class="mb-3">
				<label for="mng">star_mng</label>
				<input class="form-control" type="text" id="mng" v-model="star.mng" ref="mng" />
			</div>
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
<style scoped></style>
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
				msg: "",
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
						if (res.data === 1) {
							alert("도서 등록 성공");
							this.$router.push({
								path: "/board/detail/" + this.board.no,
							});
						} else {
							alert("도서 등록 실패");
						}
					})
					.catch(() => {
						alert("도서 등록 실패");
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
	},
};
</script>
