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
					<label for="author">글쓴이</label>
					<input class="form-control" type="text" id="author" v-model="board.author" ref="author" />
				</div>
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
</style>
<script>
import rest from "@/js/httpCommon.js";
export default {
	data() {
		return {
			board: {
				no: "",
				title: "",
				author: "",
				date: "",
				content: "",
			},
		};
	},
	created() {
		this.board.no = this.$route.params.no;
		rest
			.axios({
				method: "get",
				url: "/notice/detail/" + this.board.no,
			})
			.then((res) => {
				console.log(res.data);
				this.board = res.data.board;
			})
			.catch((err) => {
				alert("목록 조회 실패");
				console.log(err);
			});
	},
	methods: {
		goWrite() {
			this.star.no = this.board.no;
			if (this.checkValidate()) {
				rest
					.axios({
						url: "/notice/update",
						method: "put",
						data: this.board, 
					})
					.then((res) => {
						console.log(res);
						if (res.status === 200) {
							alert("공지사항 수정 성공");
							this.$router.push({
								path: "/notice/detail/" + this.board.no,
							});
						} else {
							alert("공지사항 수정 실패");
						}
					})
					.catch(() => {
						alert("공지사항 수정 실패");
					});
			}
		},
		checkValidate() {
			let keys = ["no", "title", "author", "date", "content"];
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
				path: "/notice/list",
			});
			//console.log(noClicked);
		},
	},
};
</script>
