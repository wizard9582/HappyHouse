/* eslint-disable */
import Vue from "vue";
import VueRouter from "vue-router";
import HappyHouse from "../components/happyhouse/happyhouse.vue";

import boardCreate from "../components/board/boardCreate.vue";
import boardDetail from "../components/board/boardDetail.vue";
import boardList from "../components/board/boardList.vue";
import boardModify from "../components/board/boardModify.vue";

import map from "../components/map/map.vue";
import mapCompare from "../components/map/mapCompare.vue";
import mapDetail from "../components/map/mapDetail.vue";

import mypage from "../components/mypage/mypage.vue";
import mypageCreate from "../components/mypage/mypageCreate.vue";
import mypageModify from "../components/mypage/mypageModify.vue";

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
		path: "/board/create",
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
		path: "/map/compare",
		component: mapCompare,
	},
	{
		path: "/map/detail/:aptName",
		component: mapDetail,
	},
	{
		path: "/mypage/mypage",
		component: mypage,
	},
	{
		path: "/mypage/create",
		component: mypageCreate,
	},
	{
		path: "/mypage/modify",
		component: mypageModify,
	},
	{
		path: "/notice/create",
		component: noticeCreate,
	},
	{
		path: "/notice/detail",
		component: noticeDetail,
	},
	{
		path: "/notice/modify",
		component: noticeModify,
	},
	{
		path: "/notice/list",
		component: noticeList,
	},
];

const router = new VueRouter({
	mode: "history",
	base: process.env.BASE_URL,
	routes,
});
export default router;
