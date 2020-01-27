<template>
<!--    通讯录-->
    <div>
        <div class="container text-center">
            <div>
                <nav class="navbar navbar-inverse navbar-fixed-top">
                    <a v-on:click="returnFunction">
                        <span class="glyphicon glyphicon-chevron-left return"></span>
                    </a>
                    <h1 class="text-center title-font" style="margin-top: 5px;margin-right: 1em">通讯录</h1>
                </nav>
            </div>
            <div style="margin-top: 5em" >
                <el-input style="width: 70%;float: left;" placeholder="需要搜索的姓名或部门" v-model="input" clearable />
                <el-button v-on:click="addressSearch" style="width: 29%;margin-left: 1%" type="primary" plain>搜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;索</el-button>
            </div>
            <el-divider></el-divider>
<!--            搜索信息栏-->
            <div v-bind:class="{'hidden':isSearch}">
                <div class="text-left">
                    <span>搜素“XXX”信息如下：</span>
                </div><br>
                <div>
                    <el-table :data="tableData" stripe style="width: 99.9%">
                        <el-table-column prop="name" label="姓名"></el-table-column>
                        <el-table-column prop="department" label="部门"></el-table-column>
                        <el-table-column prop="post" label="职务"></el-table-column>
                        <el-table-column prop="class" label="班级"></el-table-column>
                        <el-table-column fixed="right" label="操作" width="100">
                            <template slot-scope="scope">
                            <el-button v-on:click="addressWatch(scope.row)" type="text">查看</el-button>
                            <el-button type="text">消息</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </div>
            </div>
<!--            查看详情栏-->
            <div v-bind:class="{'hidden':isWatch}">
                查看信息
                <el-table :data="watchData" style="width: 99.9%">
                    <el-table-column prop="name" label="姓名"></el-table-column>
                    <el-table-column prop="department" label="部门"></el-table-column>
                    <el-table-column prop="post" label="职务"></el-table-column>
                    <el-table-column prop="class" label="班级"></el-table-column>
                </el-table>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "AddressListPage",
        data:function(){
            return{
                input:'',
                tableData: [{
                    class: '计科172',
                    name: '杨旭东',
                    department: 'a',
                    post:'a'
                },{
                        class: '计科172',
                        name: '杨旭东',
                        department: 'b',
                        post:'b'
                },{
                        class: '计科172',
                        name: '杨旭东',
                        department: 'c',
                        post:'c'
                },{
                        class: '计科172',
                        name: '杨旭东',
                        department: 'd',
                        post:'d'
                }],
                isWatch:true,
                isSearch:true,
                watchData:{},
            }
        },
        props:{
            data:Boolean
        },
        methods:{
            returnFunction:function () {
                this.$emit("AddressReturn",true)
            },
            addressSearch:function () {
                this.isSearch = false
                this.isWatch = true
            },
            addressWatch:function (val) {
                this.isSearch = true
                this.isWatch = false
                this.watchData = val
                // eslint-disable-next-line no-console
                console.log(val)
                // eslint-disable-next-line no-console
                console.log(this.watchData)
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
    .hidden{
        display: none;
    }
</style>