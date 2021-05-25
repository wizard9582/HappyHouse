<template>
    <div id = "map" class="row">
        <div class = "col-7 m-5">        
            <div id="kakaomap" style="width:100%;height:800px; flow:left"></div>
        </div>
        <div class = "col-3 card-body bg-gray" v-show="showCard1 || showCard2">
            <b-card
            v-show="showCard1"
                :title= "selectApart1"
                img-src="https://ifh.cc/g/YGIPYR.jpg"
                img-alt="Image"
                img-top
                tag="article"
                style="width:70%"
                class="mb-2">
                <hr>
                <b-button variant="primary" @click="showDetail(1)">상세정보</b-button>
                <b-button variant="primary" @click="discard1">비우기</b-button>
            </b-card>
            <b-button variant="danger" class="m-3" v-show="showCard1 && showCard2">주택비교</b-button>
            <b-card
            v-show="showCard2"
                :title= "selectApart2"
                img-src="https://ifh.cc/g/YGIPYR.jpg"
                img-alt="Image"
                img-top
                tag="article"
                style="width:70%"
                class="mb-2">
                <hr>
                <b-button variant="primary" @click="showDetail(2)">상세정보</b-button>
                <b-button variant="primary" @click="discard2">비우기</b-button>
            </b-card>
        </div>
    </div>
</template>
<style scoped>
</style>
/* eslint-disable */
<script>
import rest from "@/js/httpCommon.js"
export default {
    data(){
        return{
            showCard1:false,
            showCard2:false,
            selectApart1:"",
            selectApart2:"",
            apartInfo:{},
            dong:""
        }
    },
    mounted(){
        this.dong = this.$route.params.dong;
        rest.axios({
                method: "get",
                url: "/house/houseInfo/"+ this.dong,
            })
                .then((res) => {
                    this.apartInfo = res.data;
                })
                .catch((err) => {
                    alert("목록 조회 실패");
                    console.log(err);
                })
                .finally(() => {
                    if (window.kakao && window.kakao.maps) {
                        this.initMap()
                    } else {
                        const script = document.createElement('script')
                        script.onload = () => kakao.maps.load(this.initMap);
                        script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=a29e81b196aa8c99715b31d7ea6dae8e'
                        document.head.appendChild(script)
                    }
                });
    },
    methods: {
        initMap () {
            let thisvue = this;
            var positions = this.apartInfo;
            //console.log(positions[0].lat,positions[0].lng);
            const container = document.querySelector('#kakaomap')
            const options = {
            center: new kakao.maps.LatLng(positions[0].lat,positions[0].lng),
            level: 3
            }

            const map = new kakao.maps.Map(container, options)
            const mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPLEFT);
            const zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);


            positions.forEach(position => {
                var marker = new kakao.maps.Marker({
                    map: map, // 마커를 표시할 지도
                    position: new kakao.maps.LatLng(position.lat,position.lng), 
                });
                marker.name = position.name;

                // 마커에 표시할 인포윈도우를 생성합니다 
                var infowindow = new kakao.maps.InfoWindow({
                    content: '<div>'+ position.name +'</div>' // 인포윈도우에 표시할 내용
                });

                // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
                // 이벤트 리스너로는 클로저를 만들어 등록합니다 
                // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
                kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                kakao.maps.event.addListener(marker, 'click', makeClickListener(marker));
            });

            // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
            function makeOverListener(map, marker, infowindow) {
                return function() {
                    infowindow.open(map, marker);
                };
            }
            // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
            function makeOutListener(infowindow) {
                return function() {
                    infowindow.close();
                };
            }

            function makeClickListener(marker) {
                return ()=>{
                        thisvue.openCard(marker.name);
                    }
            }
            
        },
        openCard(aptName){
            if(this.showCard1){
                this.showCard2 = true;
                this.selectApart2 = aptName;
            }else{
                this.showCard1 = true;
                this.selectApart1 = aptName;
            }
        },
        showDetail(target){

            if(target == 1){
                this.$router.push({
                    path: "/map/detail/" + this.selectApart1,
                });
            }else{
                this.$router.push({
                    path: "/map/detail/" + this.selectApart2,
                });
            }
        },
        discard1(){
            this.showCard1 = false;
            this.selectApart1 = "";
        },
        discard2(){
            this.showCard2 = false;
            this.selectApart2 = "";
        }
    }
}
</script>