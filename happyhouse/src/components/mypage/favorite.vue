<template>
    <div>
        <div class="row">
            <div class="col-4"></div>
            <div class="col-4">
                <div class="table-responsive project-list">
                    <b-table
                        hover
                        :items="favorites"
                        clickable
                        @row-clicked="rowClicked"
                        :filter="keyword"
                    ></b-table>
                </div>
            </div>
            <div class="col-4"></div>
        </div>
    </div>
</template>
<style scoped>
</style>
<script>
export default {
    data(){
        return{
            favorites : {},
        }
    },
    created(){
        let id = localStorage.getItem('id');
        let items = localStorage.getItem("itemof"+id);

        if(items!=null){
            this.favorites = JSON.parse(items);
        }
    },
    methods: {
        rowClicked(item){
            if(item.type == 0){
                this.$router.push({
				    path: "/map/detail/" + item.name,
		        });
            }else{
                this.$router.push({
				    path: "/map/" + item.name,
		        });
            }
        }
    },
}
</script>