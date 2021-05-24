<template>
    <div id = "mapDetail" class="container card">
        <div class="row card-body">
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
                    <div class="row">
                        <div class="col-4"><line-chart></line-chart></div>
                        <div class="col-4"><bar-chart></bar-chart></div>
                    </div>
                <div>

                </div>
            </div>
        </div>
    </div>
</template>
<style scoped>
</style>
<script>
import LineChart from '../common/LineChart.vue'
import BarChart from '../common/BarChart.vue'
export default {
  components: { LineChart, BarChart },
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