<template>
    <div id = "mapDetail" class="container">
        <div class="row">
            <div class="col-4">
                <img :src="require('@/assets/ssafy.png')" alt="houseImg"/>
                <h3>{{houseInfo.houseName}}</h3>
                <div></div>
                <h3>평가 : {{stars.allStar}} / 5</h3>
                <div></div>
                <h3>게시판</h3>
                <div></div>
            </div>
            <div class="col-8">
                <h3>최근 거래 내역</h3>
                <div>

                </div>
                <h3>거래추이</h3>
                <div>

                </div>
            </div>
        </div>
    </div>
</template>
<style scoped>
</style>
<script>
export default {
    data(){
        return{
            houseInfo:{
                houseName:"테스트용"
            },
            stars:{
                allStar : "5.0"
            },
            apartDeal:[],
            board:[],
        }
    },
}
</script>