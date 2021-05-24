/* eslint-disable */
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
        const container = document.querySelector('#kakaomap')
        const options = {
        center: new kakao.maps.LatLng(35.19656853772262, 129.0807270648317),
        level: 3
        }
        const map = new kakao.maps.Map(container, options)
        const markerPosition = new kakao.maps.LatLng(35.19656853772262, 129.0807270648317);

        const marker = new kakao.maps.Marker({
        position: markerPosition
        });
        marker.setMap(map)
        }
    }
}
</script>