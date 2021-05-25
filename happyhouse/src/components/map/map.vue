/* eslint-disable */
<template>
    <div id = "map" class="row">
        <router-link to="/map/detail">html 확인용 임시링크</router-link>
        <div class = "col-7 m-5">        
            <div id="kakaomap" style="width:100%;height:800px; flow:left"></div>
        </div>
        <div class = "col-4 card-body bg-gray" v-show="selectApart">
            <b-card
                title="집 이름"
                img-src="https://picsum.photos/600/300/?image=25"
                img-alt="Image"
                img-top
                tag="article"
                style="width:90%"
                class="mb-2">

                <hr>

                <b-card-text>
                주택 정보들 1
                주택 정보들 2
                주택 정보들 3
                주택 정보들 4
                </b-card-text>
                <b-card-text>
                주택 정보들 1
                주택 정보들 2
                주택 정보들 3
                주택 정보들 4
                </b-card-text>
                <b-card-text>
                주택 정보들 1
                주택 정보들 2
                주택 정보들 3
                주택 정보들 4
                </b-card-text>

                <hr>
                
                <b-button href="#" variant="primary">상세정보</b-button>
            </b-card>
        </div>
    </div>
</template>
<style scoped>
</style>

<script>

export default {
    data(){
        return{
            selectApart:"",
            apartInfo:{},
        }
    },
    created(){

    },
    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.initMap()
        } else {
            const script = document.createElement('script')
            script.onload = () => kakao.maps.load(this.initMap);
            script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=a29e81b196aa8c99715b31d7ea6dae8e'
            document.head.appendChild(script)
        }
    },
    methods: {
    initMap () {
        var iwContent = '<div style="padding:5px;">Hello World!</div>';
        var infowindow = new kakao.maps.InfoWindow({
            content : iwContent
        });


        const container = document.querySelector('#kakaomap')
        const options = {
        center: new kakao.maps.LatLng(37.498004414546934, 127.02770621963765),
        level: 3
        }
        const map = new kakao.maps.Map(container, options)
        const markerPosition = new kakao.maps.LatLng(37.498004414546934, 127.02770621963765);
        
        const mapTypeControl = new kakao.maps.MapTypeControl();
        map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPLEFT);
        const zoomControl = new kakao.maps.ZoomControl();
        map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
        
        const marker = new kakao.maps.Marker({
        position: markerPosition
        });

        kakao.maps.event.addListener(marker, 'click', function() {
		//alert('마커를 클릭했습니다!');
		});


		kakao.maps.event.addListener(marker, 'mouseover', function() {
		//console.log('마커에 mouseover 이벤트가 발생했습니다!');
        infowindow.open(map, marker);
		});


		kakao.maps.event.addListener(marker, 'mouseout', function() {
		//console.log('마커에 mouseout 이벤트가 발생했습니다!');
        infowindow.close();
		});

        marker.setMap(map)
        
        },
    }
}
</script>