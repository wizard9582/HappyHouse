<template>
    <div id = "map">
        <router-link to="/map/detail">html 확인용 임시링크</router-link>
        <div id="kakaomap" class = "container pt-3" style="width:80%;height:800px;"></div>
    </div>
</template>
<style scoped>
</style>

<script>

export default {
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
        center: new kakao.maps.LatLng(37.5666805, 126.9784147),
        level: 3
        }
        const map = new kakao.maps.Map(container, options)
        const markerPosition = new kakao.maps.LatLng(37.5666805, 126.9784147);
        
        const mapTypeControl = new kakao.maps.MapTypeControl();
        map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPLEFT);
        const zoomControl = new kakao.maps.ZoomControl();
        map.addControl(zoomControl, kakao.maps.ControlPosition.LEFT);
        
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
        }
    }
}
</script>