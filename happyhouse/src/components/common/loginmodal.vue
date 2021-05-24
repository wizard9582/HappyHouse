<template>
<transition name="login-modal">
    <div class="modal-mask">
        <div class="modal-wrapper">
            <div class="modal-container">
                <div class="modal-header">
                    <slot name="header">로그인</slot>
                </div>

                <div class="modal-body">
                    <slot name="body">
                        <div class="input-group-prepend">
                            <span class="input-group-text">ID</span>
                        </div>
                        <input type="text" class="form-control" v-model="user.id" placeholder="Username">
                        <div class="input-group-prepend">
                            <span class="input-group-text">PW</span>
                        </div>
                        <input type="text" class="form-control" v-model="user.pass" placeholder="Password">
                    </slot>
                </div>

                <div class="modal-footer">
                    <slot name="footer">
                        <button class="btn primary-btn" @click="validationCheck">로그인</button>
                        <button class="btn danger-btn" @click="$emit('close')">취소</button>
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
            if(this.user.id != null && this.user.pass != null){
                this.$emit('tryLogin',this.user);
            }else{
                alert("ID와 비밀번호를 모두 입력하세요!");
            }
        }
    }
}
</script>