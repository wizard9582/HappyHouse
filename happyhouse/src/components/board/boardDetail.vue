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
							<th>번호</th>
							<td>{{ board.no }}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="5">{{ board.title }}</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th colspan="6">내용</th>
						</tr>
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
<style scoped></style>
<script>
import rest from "@/js/httpCommon.js";
export default {
	data() {
		return {
			board: {},
			no: "",
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
				path: "/list",
			});
			//console.log(noClicked);
		},
		goEdit() {
			this.$router.push({
				path: "/edit/" + this.no,
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
						path: "/list",
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
