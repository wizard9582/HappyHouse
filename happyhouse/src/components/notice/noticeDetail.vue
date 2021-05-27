/* eslint-disable */
<template>
	<div>
		<hr />
		<b-row>
			<b-col></b-col>
			<b-col cols="6">
				<table class="table table-bordered">
					<colgroup>
						<col width="10%" />
						<col width="20%" />
						<col width="10%" />
						<col width="25%" />
						<col width="10%" />
						<col width="25%" />
					</colgroup>
					<thead>
						<tr>
							<th>제목</th>
							<td colspan="5">{{ board.title }}</td>
						</tr>
						<tr>
							<th>번호</th>
							<td>{{ board.no }}</td>
							<th>작성자</th>
							<td>{{ board.author }}</td>
                            <th>날짜</th>
							<td>{{ board.date }}</td>
						</tr>
					</thead>
				</table>
				<hr>
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td colspan="6">{{ board.content }}</td>
						</tr>
					</tbody>
				</table>
			</b-col>
			<b-col></b-col>
		</b-row>
		<b-row>
			<b-col cols="8"></b-col>
			<b-col cols="2">
				<b-button @click="goList">목록으로</b-button>
				<b-button variant="danger" @click="goDelete">삭제</b-button>
				<b-button variant="success" @click="goEdit">수정</b-button>
			</b-col>
			<b-col cols="2"></b-col>
		</b-row>
	</div>
</template>
<style scoped>
</style>
<script>
import rest from "@/js/httpCommon.js";
export default {
	data() {
		return {
			no : "",
			board: {
				no: "",
				apt: "",
				title: "",
				author: "",
				date: "",
				content: "",
			},
		};
	},
	created() {
		this.no = this.$route.params.no;
		rest
			.axios({
				method: "get",
				url: "/notice/detail/" + this.no,
			})
			.then((res) => {
				//console.log(res.data);
				this.board = res.data;
			})
			.catch((err) => {
				alert("목록 조회 실패");
				console.log(err);
			});
	},
	methods: {
		goList() {
			this.$router.push({
				path: "/notice/list",
			});
			//console.log(noClicked);
		},
		goEdit() {

			if(localStorage.getItem('id') != "admin"){
				alert("비인가 사용자입니다!");
				return;
			}

			this.$router.push({
				path: "/notice/modify/" + this.no,
			});
			//console.log(noClicked);
		},
		goDelete() {

			if(localStorage.getItem('id') != "admin"){
				alert("비인가 사용자입니다!");
				return;
			}
			rest.axios({
					method: "delete",
					url: "/notice/delete/" + this.no,
				})
				.then(() => {
					this.$router.push({
						path: "/notice/list",
					});
				})
				.catch((err) => {
					alert("삭제 실패");
					console.log(err);
				});
			//console.log(noClicked);
		},
	},
};
</script>
