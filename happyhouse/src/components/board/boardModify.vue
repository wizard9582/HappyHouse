<template>
	<div class="regist">
		<h1>글 수정</h1>
		<div class="regist_form">
			<label for="title">제목</label>
			<input type="text" id="title" v-model="board.title" ref="title" />
			<br />
			<label for="content">본문</label>
			<textarea id="content" cols="50" rows="5" v-model="board.content" ref="content"></textarea>
			<br />
			<b-button @click="goList">목록으로</b-button>
			<b-button variant="success" @click="goUpdate">수정</b-button>
			<b-button variant="danger" @click="goList">취소</b-button>
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
				title: "",
				content: "",
			},
		};
	},
	created() {
		this.board.no = this.$route.params.no;
	},
	methods: {
		goUpdate() {
			if (this.checkValidate()) {
				rest
					.axios({
						url: "/board/update",
						method: "put",
						data: this.board, //
					})
					.then((res) => {
						if (res.data === 1) {
							alert("도서 등록 성공");
							this.$router.push({
								path: "/view/" + this.board.no,
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
			let keys = ["title", "content"];
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
				path: "/list",
			});
			//console.log(noClicked);
		},
	},
};
</script>
