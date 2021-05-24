<template>
	<div>
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="table-responsive project-list">
							<b-table
								hover
								:items="boards"
								clickable
								@row-clicked="rowClicked"
								:filter="keyword"
							></b-table>
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
								<li>
									<b-button variant="success" @click="goEdit">글쓰기</b-button>
								</li>
							</ul>
						</div>
					</div>
				</div>
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
			boards: {},
		};
	},
	created() {
		rest
			.axios({
				method: "get",
				url: "/board/search/",
			})
			.then((res) => {
				console.log(res);
				this.boards = res.data;
				//this.board = res.data;
			})
			.catch((err) => {
				alert("목록 조회 실패");
				console.log(err);
			});
	},
	methods: {
		rowClicked(items) {
			//console.log(items);
			this.$router.push({
				path: "/board/detail/" + items.no,
			});
			//console.log(noClicked);
		},
	},
};
</script>
