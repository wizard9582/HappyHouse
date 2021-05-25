/* eslint-disable */
<template>
<transition name="regist-modal">
    <div class="modal-mask">
        <div class="modal-wrapper">
            <div class="modal-container">
                <div class="modal-header">
                    <slot name="header">회원가입</slot>
                </div>

				<div class="modal-body">
					<label for="loginID">ID :</label>
					<input type="text" class="form-control" id="loginID" v-model="user.id">
					<label for="loginPW">Password :</label>
					<input type="password" class="form-control" id="loginPW" v-model="user.pass">
                    <label for="Name">Name :</label>
					<input type="text" class="form-control" id="Name" v-model="user.name">
                    <label for="Nick">NickName :</label>
					<input type="text" class="form-control" id="Nick" v-model="user.nick">
                    <label for="Address">Address :</label>
					<input type="text" class="form-control" id="Address" v-model="user.address">
                    <label for="Phone">Phone :</label>
					<input type="text" class="form-control" id="Phone" v-model="user.phone">
				</div>

                <div class="modal-footer">
                    <slot name="footer">
                        <button class="btn btn-primary" @click="validationCheck">회원가입</button>
                        <button class="btn btn-danger" @click="$emit('close')">취소</button>
                    </slot>
                </div>
            </div>
        </div>
    </div>
</transition>
</template>
<style scoped>
</style>
<script>
export default {
    data(){
        return{
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
    methods:{
        validationCheck(){
            if(this.user.id != null && this.user.pass != null){
                this.$emit('tryRegist',this.user);
            }else{
                alert("ID와 비밀번호를 모두 입력하세요!");
            }
        }
    }
}
</script>