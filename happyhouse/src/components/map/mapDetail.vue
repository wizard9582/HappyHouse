/* eslint-disable */
<template>
    <div id = "mapDetail" class="container card">
        <div class="row card-body">
            <div class="col-4">
                <img  src="https://ifh.cc/g/YGIPYR.jpg" alt="houseImg"/>
                <h3>{{houseInfo.houseName}}</h3>
                <div></div>
                <h3>평가 : {{stars.allStar}} / 5</h3>
                <div></div>
                <h3>게시판</h3>
                <div></div>
            </div>
            <div class="col-8">
                <h7>최근 거래 내역</h7>
                <div>

                </div>
                <h7>거래추이</h7>
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
import rest from "@/js/httpCommon.js"
export default {
    components: { LineChart, BarChart },
    data(){
        return{
            aptName:"",
            houseInfo:{
            },
            stars:{
                allStar : "5.0"
            },
            apartDeal:[],
            board:[],
        }
    },
    created(){
        this.aptName = this.$route.params.aptName;
        rest.axios({
                method: "get",
                url: "/board/search/"+ this.aptName,
            })
                .then((res) => {
                    //console.log(res.data);
                    this.houseInfo = res.data;
                })
                .catch((err) => {
                    alert("목록 조회 실패");
                    console.log(err);
                })
                .finally(() => {
                });
    }
}
</script>