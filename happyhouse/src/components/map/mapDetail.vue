/* eslint-disable */
<template>
    <div id = "mapDetail" class="container m-3">
        <div class="row card-body">
            <div class="col-4">
                <img  src="https://ifh.cc/g/YGIPYR.jpg" alt="houseImg"/>
                <br>
                <h3>{{aptName}}</h3>
                <div></div>
                <br><br>
                <h5>종합평가 : {{avgStar}} / 5</h5> <star-rating :rating="avgStar" :read-only="true" :increment="0.01" :show-rating="false"></star-rating>
                <div></div>
                <br>
                <h5>최근리뷰</h5>
                <b-list-group flush v-for="(board, index) in boards" :key="index" >
                    <b-list-group-item v-if="index > boardCount - 4" class="m-1">
                        <span>
                            {{board.title}} <star-rating :rating="stars[index].als" :read-only="true" :increment="0.01" :show-rating="false" :inline="true" :star-size="20"></star-rating>
                        </span>
                    </b-list-group-item>
                </b-list-group>
            </div>
            <div class="col-8">
                <h6>최근 거래 내역</h6>
                    <b-list-group flush v-for="(houseDeal, index) in houseDeals" :key="index" >
                        <b-list-group-item v-if="index > dealCount - 4" class="m-1">
                            <span>
                                {{houseDeal.dealYear}}년 {{houseDeal.dealMonth}}월 - {{houseDeal.area | areaFilter}}, {{houseDeal.price | priceFilter}}
                            </span>
                        </b-list-group-item>
                    </b-list-group>
                <h5>거래추이</h5>
                <h6>가격변화</h6>
                <area-chart id="linechart" :data="monthlyPrice" :key="componentKey"></area-chart>
                <h6>거래량 변화</h6>
                <column-chart id="columnchart" :data="monthlyDeal" :key="componentKey"></column-chart>
            </div>
        </div>
    </div>
</template>
<style scoped>
</style>
<script>
import rest from "@/js/httpCommon.js"
import StarRating from 'vue-star-rating'

export default {
    components: {StarRating },
    data(){
        return{
            componentKey : 0,
            aptName:"",
            boardCount : "",
            dealCount : "",
            houseDeals:[],
            boards:[],
            stars:[],
            monthlyDeal:{"1월" : 0,"2월" : 0,"3월" : 0,"4월" : 0,"5월" : 0,"6월" : 0,"7월" : 0,"8월" : 0,"9월" : 0,"10월" : 0,"11월" : 0,"12월" : 0},
            sumPrice:{"1월" : 0,"2월" : 0,"3월" : 0,"4월" : 0,"5월" : 0,"6월" : 0,"7월" : 0,"8월" : 0,"9월" : 0,"10월" : 0,"11월" : 0,"12월" : 0},
            monthlyPrice:{"1월" : 0,"2월" : 0,"3월" : 0,"4월" : 0,"5월" : 0,"6월" : 0,"7월" : 0,"8월" : 0,"9월" : 0,"10월" : 0,"11월" : 0,"12월" : 0},
        }
    },
    created(){
        this.aptName = this.$route.params.aptName;
        rest.axios({
                method: "get",
                url: "/house/houseDeal/"+ this.aptName,
            })
                .then((res) => {
                    res.data.forEach(dat => {
                        //console.log(dat);
                        this.houseDeals.push(dat);
                    });
                })
                .catch((err) => {
                    alert("목록 조회 실패");
                    console.log(err);
                })
                .finally(() => {
                    this.houseDeals.forEach(deal => {

                        this.monthlyDeal[deal.dealMonth + "월"] ++;
                        this.sumPrice[deal.dealMonth + "월"] += (parseInt(deal.price) / parseInt(deal.area));
                    });

                    for(let i = 1; i < 13; i++){
                        if(this.monthlyDeal[i + "월"] != 0){
                            this.monthlyPrice[i + "월"] = this.sumPrice[i + "월"] / this.monthlyDeal[i + "월"];
                        }else{
                            this.monthlyPrice[i + "월"] = 0;
                        }
                        this.componentKey += 1;
                    }

                    this.dealCount = this.houseDeals.length;
                            rest.axios({
                                method: "get",
                                url: "/board/search/"+ this.aptName,
                            })
                                .then((res) => {
                                    res.data.forEach(dat => {
                                        //console.log(dat);
                                        this.boards.push(dat.board);
                                        this.stars.push(dat.star);
                                    });
                                })
                                .catch((err) => {
                                    alert("목록 조회 실패");
                                    console.log(err);
                                })
                                .finally(() => {
                                    this.boardCount = this.boards.length;
                                });
                });
    },
    computed : {
        avgStar(){
            let sum = 0;
            this.stars.forEach(star =>{
                sum += star.als;
            });
            return sum / this.stars.length;
        }
    },
    filters: {
        areaFilter(area) {
            if (!area) return ''
            area = parseFloat(area) / 3;
            return area.toFixed(3) + "평형";
        },
        priceFilter(price) {
            if (!price) return ''
            let uk = Math.floor(parseFloat(price) / 10);
            let cheon = parseInt(price) % 10;

            if(cheon == 0){
                return uk + "억 원";
            }else{
                return uk + "억 " + cheon + "천만원";
            }
        }
    },
    methods: {
        getDeal(){
            return this.monthlyDeal;
        },
        getPrice(){
            return this.monthlyPrice;
        }
    },
}
</script>