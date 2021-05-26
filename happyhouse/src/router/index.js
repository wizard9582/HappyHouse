/* eslint-disable */
import Vue from "vue";
import VueRouter from "vue-router";
import HappyHouse from "../components/happyhouse/happyhouse.vue";

import boardCreate from "../components/board/boardCreate.vue";
import boardDetail from "../components/board/boardDetail.vue";
import boardList from "../components/board/boardList.vue";
import boardModify from "../components/board/boardModify.vue";

import map from "../components/map/map.vue";
import mapDetail from "../components/map/mapDetail.vue";
import mapCompare from "../components/map/mapCompare.vue";

import mypage from "../components/mypage/mypage.vue";
import favorite from "../components/mypage/favorite.vue";

import noticeCreate from "../components/notice/noticeCreate.vue";
import noticeDetail from "../components/notice/noticeDetail.vue";
import noticeList from "../components/notice/noticeList.vue";
import noticeModify from "../components/notice/noticeModify.vue";

Vue.use(VueRouter);

const routes = [
	{
		path: "/",
		component: HappyHouse,
	},
	{
		path: "/board/create/:no",
		component: boardCreate,
	},
	{
		path: "/board/detail/:no",
		component: boardDetail,
	},
	{
		path: "/board/list",
		component: boardList,
	},
	{
		path: "/board/modify/:no",
		component: boardModify,
	},
	{
		path: "/map/:dong",
		component: map,
	},
	{
		path: "/map/detail/:aptName",
		component: mapDetail,
	},
	{
		path: "/map/compare/:aptName1/:aptName2",
		component: mapCompare,
	},
	{
		path: "/mypage",
		component: mypage,
	},
	{
		path: "/notice/create/:no",
		component: noticeCreate,
	},
	{
		path: "/notice/detail/:no",
		component: noticeDetail,
	},
	{
		path: "/notice/modify/:no",
		component: noticeModify,
	},
	{
		path: "/notice/list",
		component: noticeList,
	},
	{
		path: "/favorite",
		component: favorite,
	},
];

const router = new VueRouter({
	mode: "history",
	base: process.env.BASE_URL,
	routes,
});
export default router;
