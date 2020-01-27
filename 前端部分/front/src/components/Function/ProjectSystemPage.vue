<template>
<!--    项目制-->
    <div>
        <div class="container text-center">
            <div>
                <nav class="navbar navbar-inverse navbar-fixed-top">
                    <a v-on:click="returnFunction">
                        <span class="glyphicon glyphicon-chevron-left return"></span>
                    </a>
                    <h1 class="text-center title-font" style="margin-top: 5px;margin-right: 1em">项目制</h1>
                </nav>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ProjectSystemPage",
        props:{
            data:Boolean
        },
        methods:{
            returnFunction:function () {
                this.$emit("ProjectReturn",true)
            }
        }
    }
</script>

<style scoped>
    .title-font{
        font-size: 32px;
        color: white;
        font-family: 微软雅黑;
    }
    .return{
        margin-left: 0.4em;
        margin-top: 0.5em;
        float: left;
        font-size: 1.5em;
        color: white;
    }
</style>