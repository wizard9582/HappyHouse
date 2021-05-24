/* eslint-disable */
<template>
	<div class="home">
		<h2 align="center">Main</h2>
		<br />
		<div class="container">
			<div class="row">
				<div class="col-lg-4 bg-light p-3">
					<b-cardno-body style="max-width: 20rem;">
						<b-card-body>
							<b-card-title>게시판</b-card-title>
							<b-card-text>자유롭게 이야기를 나누는 곳입니다.</b-card-text>
						</b-card-body>

						<b-list-group flush>
							<b-list-group-item>Cras justo odio</b-list-group-item>
							<b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
							<b-list-group-item>Vestibulum at eros</b-list-group-item>
							<b-list-group-item>Cras justo odio</b-list-group-item>
							<b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
							<b-list-group-item>Vestibulum at eros</b-list-group-item>
							<b-list-group-item>Cras justo odio</b-list-group-item>
							<b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
							<b-list-group-item>Vestibulum at eros</b-list-group-item>
						</b-list-group>

					</b-cardno-body>
				</div>
				<div class="col-lg-4 bg-light p-3">
					<b-cardno-body style="max-width: 20rem;">
						<b-card-body>
							<b-card-title>주변지도</b-card-title>
							<b-card-text>현재 위치를 기준으로 거래지도를 나타냅니다.</b-card-text>
						</b-card-body>
						<div id="kakaomap" style="width:90%;height:70%; flow:left"></div>
					</b-cardno-body>
				</div>
				<div class="col-lg-4 bg-light p-3">
					<b-cardno-body style="max-width: 20rem;">
						<b-card-body>
							<b-card-title>최근 리뷰</b-card-title>
							<b-card-text>주택의 평가를 남기는 곳입니다.</b-card-text>
						</b-card-body>

						<b-list-group flush>
							<b-list-group-item>Cras justo odio</b-list-group-item>
							<b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
							<b-list-group-item>Vestibulum at eros</b-list-group-item>
							<b-list-group-item>Cras justo odio</b-list-group-item>
							<b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
							<b-list-group-item>Vestibulum at eros</b-list-group-item>
							<b-list-group-item>Cras justo odio</b-list-group-item>
							<b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
							<b-list-group-item>Vestibulum at eros</b-list-group-item>
						</b-list-group>

					</b-cardno-body>
				</div>
			</div>
		</div>
		<br/><br/><br/><br/><br/><br/>
		<hr/>
	</div>
</template>
<script>
export default {
	name: "Home",
	components: {},
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
};
</script>

<style scoped></style>
