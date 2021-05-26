/* eslint-disable */
<template>
<transition name="login-modal">
    <div class="modal-mask">
        <div class="modal-wrapper">
            <div class="modal-container">
                <div class="modal-header">
                    <slot name="header">로그인</slot>
                </div>
				<div class="modal-body">
					<label for="loginID">ID :</label>
					<input type="text" class="form-control" id="loginID" v-model="user.id">
					<label for="loginPW">Password :</label>
					<input type="password" class="form-control" id="loginPW" v-model="user.pass">
				</div>
                <div class="modal-footer">
                    <slot name="footer">
                        <button class="btn btn-success" @click="validationCheck">로그인</button>
                        <button class="btn btn-primary" @click="$emit('tryRegist')">회원가입</button>
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
                pass : ""
            },
        }
    },
    methods:{
        validationCheck(){
            if(this.user.id != "" && this.user.pass != ""){
                this.$emit('tryLogin',this.user);
            }else{
                alert("ID와 비밀번호를 모두 입력하세요!");
            }
        }
    }
}
</script>