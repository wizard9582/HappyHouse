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
							<th>번호</th>
							<td>{{ board.no }}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>{{ board.author }}</td>
						</tr>
						<tr>
							<th>아파트명</th>
							<td>{{ board.apt }}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="5">{{ board.title }}</td>
						</tr>

						<tr>
							<th>평점als</th>
							<td colspan="5">{{ star.als }}</td>
							<th>평점sft</th>
							<td colspan="5">{{ star.sft }}</td>
							<th>평점trf</th>
							<td colspan="5">{{ star.trf }}</td>
							<th>평점env</th>
							<td colspan="5">{{ star.env }}</td>
							<th>평점cvn</th>
							<td colspan="5">{{ star.cvn }}</td>
							<th>평점mng</th>
							<td colspan="5">{{ star.mng }}</td>
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
				<div class="stars">
					<label for="als">종합평점</label>
					<input class="star star-5" id="star-5" type="radio" name="star" value="5" />
					<label class="star star-5" for="star-5"></label>
					<input class="star star-4" id="star-4" type="radio" name="star" value="4" />
					<label class="star star-4" for="star-4"></label>
					<input class="star star-3" id="star-3" type="radio" name="star" value="3" />
					<label class="star star-3" for="star-3"></label>
					<input class="star star-2" id="star-2" type="radio" name="star" value="2" />
					<label class="star star-2" for="star-2"></label>
					<input class="star star-1" id="star-1" type="radio" name="star" value="1" />
					<label class="star star-1" for="star-1"></label>
				</div>
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
