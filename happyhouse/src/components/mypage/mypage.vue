<template>
<div>
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <label for="loginID">ID :</label>
            <input type="text" class="form-control" id="loginID" v-model="user.id">
            <label for="PW">PW :</label>
            <input type="password" class="form-control" id="PW" v-model="user.pass">
            <label for="Name">Name :</label>
            <input type="text" class="form-control" id="Name" v-model="user.name">
            <label for="Nick">NickName :</label>
            <input type="text" class="form-control" id="Nick" v-model="user.nick">
            <label for="Address">Address :</label>
            <input type="text" class="form-control" id="Address" v-model="user.address">
            <label for="Phone">Phone :</label>
            <input type="text" class="form-control" id="Phone" v-model="user.phone">
        </div>
        <div class="col-4"></div>
    </div>
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
				<b-button variant="success" @click="edit">수정</b-button>
				<b-button variant="danger" @click="withdraw">탈퇴</b-button>
        </div>
        <div class="col-4"></div>
    </div>
</div>
</template>
<style scoped>
</style>
<script>
import rest from "@/js/httpCommon.js"
export default {
    data(){
        return{
            id : "",
            user : {
                id : "",
                pass : "",
                name : "",
                nick : "",
                address : "",
                phone : "",
            },
        }
    },
    created(){
        if(!localStorage.getItem('id')){
            alert("로그인해주세요!");
            this.$router.push({
                path: "/",
            });
        }

        this.id = localStorage.getItem('id');
		rest.axios({
				method: "get",
				url: "/user/info/" + this.id,
                headers : {"jwt-auth-token" : localStorage.getItem("token")},
			})
			.then((res) => {
				//console.log(res.data);
				this.user = res.data;
			})
			.catch((err) => {
				alert("목록 조회 실패");
				console.log(err);
			});
    },
    methods: {
        edit(){
            rest.axios({
				method: "put",
				url: "/user/edit/",
                headers : {"jwt-auth-token" : localStorage.getItem("token")},
                data : this.user
			})
			.then((res) => {
                console.log(res.status);
			})
			.catch((err) => {
				alert("목록 조회 실패");
				console.log(err);
			});
        },
        withdraw(){
            rest.axios({
				method: "delete",
				url: "/user/delete/",
                headers : {"jwt-auth-token" : localStorage.getItem("token")},
                data : this.user
			})
			.then((res) => {
                console.log(res.status);
			})
			.catch((err) => {
				alert("목록 조회 실패");
				console.log(err);
			});
        }
    },
}
</script>
