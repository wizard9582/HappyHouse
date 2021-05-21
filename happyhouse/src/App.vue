<template>
	<div id="app">
		<header-comp></header-comp>
		<router-view />
		<footer-comp></footer-comp>
	</div>
</template>

<style></style>
<script>
import FooterComp from "@/components/common/footer.vue";
import HeaderComp from "@/components/common/header.vue";
export default {
	components: {
		FooterComp,
		HeaderComp,
	},
};
</script>
