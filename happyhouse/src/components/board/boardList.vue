<template>
	<div>
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="table-responsive project-list">
							<table class="table project-table table-centered table-nowrap">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">제목</th>
										<th scope="col">작성날짜</th>
										<th scope="col">아파트명</th>
										<th scope="col">작성자</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td>여기 살기 괜춘ㅇㅇ</td>
										<td>02/5/2021</td>
										<td>래미안</td>
										<td>심재원</td>
									</tr>
									<tr>
										<th scope="row">1</th>
										<td>여기 살기 괜춘ㅇㅇ</td>
										<td>02/5/2021</td>
										<td>래미안</td>
										<td>심재원</td>
									</tr>
									<tr>
										<th scope="row">1</th>
										<td>여기 살기 괜춘ㅇㅇ</td>
										<td>02/5/2021</td>
										<td>래미안</td>
										<td>심재원</td>
									</tr>
									<tr>
										<th scope="row">1</th>
										<td>여기 살기 괜춘ㅇㅇ</td>
										<td>02/5/2021</td>
										<td>래미안</td>
										<td>심재원</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- end project-list -->

						<div class="pt-3">
							<ul class="pagination justify-content-end mb-0">
								<li class="page-item disabled">
									<a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
								</li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item active"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item">
									<a class="page-link" href="#">Next</a>
								</li>
							</ul>
						</div>

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
				</div>
			</div>
		</div>
	</div>
</template>
<style scoped></style>
<script>
import rest from "@/main.js";
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
				url: "/board/search/" + this.no,
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
