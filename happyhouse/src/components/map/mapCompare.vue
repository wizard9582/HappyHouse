<template>
    <div id = "apartCompare">
        <div class="row">
            <div class="col-6">
                <canvas class="statistics-charts-radar" ref="radarChart"></canvas>
            </div>
            <div class="col-6">

            </div>
        </div>
    </div>
</template>
<style scoped>
</style>
<script>
import Chart from "chart.js";
import rest from "@/js/httpCommon.js"
export default {
    data(){
        return{
            Chart,
            aptName1 : "",
            aptName2 : "",
            aptStar1 : [],
            aptStar2 : [],
            stars1 : [],
            stars2 : [],
        }
    },
    created() {
        this.aptName1 = this.$route.params.aptName1;
        this.aptName2 = this.$route.params.aptName2;
    },
    mounted() {
        //마운트 뒤 차트를 그린다.
         rest.axios({
            method: "get",
            url: "/board/search/"+ this.aptName1,
        })
            .then((res) => {
                res.data.forEach(dat => {
                    //console.log(dat);
                    this.stars1.push(dat.star);
                });
            })
            .catch((err) => {
                alert("목록 조회 실패");
                console.log(err);
            })
            .finally(() => {
                rest.axios({
                    method: "get",
                    url: "/board/search/"+ this.aptName2,
                })
                    .then((res) => {
                        res.data.forEach(dat => {
                            //console.log(dat);
                            this.stars2.push(dat.star);
                        });
                    })
                    .catch((err) => {
                        alert("목록 조회 실패");
                        console.log(err);
                    })
                    .finally(()=>{
                        this.drawChart();
                    });
            });
    },
    methods: {
        drawChart() {
        const ctx = this.$refs.radarChart.getContext("2d");

        let length = this.stars1.length;
        console.log(length);
        let sum = {"0" : 0, "1" : 0, "2":0, "3" : 0, "4" : 0};
        this.stars1.forEach(star =>{
            console.log(star);
            sum[0] += star.sft;
            sum[1] += star.trf;
            sum[2] += star.env;
            sum[3] += star.cvn;
            sum[4] += star.mng;
        });
        for(let i = 0; i < 5; i ++){
            this.aptStar1.push(sum[i]/length);
        }

        length = this.stars2.length;
        sum = {"0" : 0, "1" : 0, "2":0, "3" : 0, "4" : 0};
        this.stars2.forEach(star =>{
            console.log(star);
            sum[0] += star.sft;
            sum[1] += star.trf;
            sum[2] += star.env;
            sum[3] += star.cvn;
            sum[4] += star.mng;
        });
        for(let i = 0; i < 5; i ++){
            this.aptStar2.push(sum[i]/length);
        }

        new Chart(ctx, {
            type: 'radar',
            data: {
                labels: ['치안','교통','주변환경','편의시설','관리'],
                datasets: [{
                    label: this.aptName1,
                    data: this.aptStar1,
                    fill: true,
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    borderColor: 'rgb(255, 99, 132)',
                    pointBackgroundColor: 'rgb(255, 99, 132)',
                    pointBorderColor: '#fff',
                    pointHoverBackgroundColor: '#fff',
                    pointHoverBorderColor: 'rgb(255, 99, 132)'
                    }, {
                    label: this.aptName2,
                    data:  this.aptStar2,
                    fill: true,
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    borderColor: 'rgb(54, 162, 235)',
                    pointBackgroundColor: 'rgb(54, 162, 235)',
                    pointBorderColor: '#fff',
                    pointHoverBackgroundColor: '#fff',
                    pointHoverBorderColor: 'rgb(54, 162, 235)'
                    }]
            },
            options: {
                scale: {
                    ticks: {
                        beginAtZero: true,
                        max: 5,
                        min: 0,
                        stepSize: 1
                    }
                }
            }
        });
        },
    }
}
</script>