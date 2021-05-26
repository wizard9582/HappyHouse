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
							<th>아파트명</th>
							<td>{{ board.apt }}</td>
							<th>작성자</th>
							<td>{{ board.author }}</td>
						</tr>
						<tr>
							<th>날짜</th>
							<td colspan="5">{{ board.date }}</td>
						</tr>
					</thead>
				</table>
				<hr>
				<table class="table table-bordered">
					<colgroup>
						<col width="25%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
					</colgroup>
					<thead>
						<tr>
							<th>종합</th>
							<th>보안</th>
							<th>교통</th>
							<th>주변환경</th>
							<th>편의시설</th>
							<th>단지관리</th>
						</tr>
						<tr>
							<th>{{ star.als }}</th>
							<td>{{ star.sft }}</td>
							<td>{{ star.trf }}</td>
							<td>{{ star.env }}</td>
							<td>{{ star.cvn }}</td>
							<td>{{ star.mng }}</td>
						</tr>
					</thead>
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
		this.no = this.$route.params.no;
		rest
			.axios({
				method: "get",
				url: "/board/detail/" + this.no,
			})
			.then((res) => {
				//console.log(res.data);
				this.board = res.data.board;
				this.star = res.data.star;
			})
			.catch((err) => {
				alert("목록 조회 실패");
				console.log(err);
			});
	},
	methods: {
		goList() {
			this.$router.push({
				path: "/board/list",
			});
			//console.log(noClicked);
		},
		goEdit() {
			this.$router.push({
				path: "/board/modify/" + this.no,
			});
			//console.log(noClicked);
		},
		goDelete() {
			rest
				.axios({
					method: "delete",
					url: "/board/delete/" + this.no,
				})
				.then(() => {
					this.$router.push({
						path: "/board/list",
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
