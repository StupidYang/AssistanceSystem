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
                        <el-table-column fixed="right" label="操作" width="100">
                            <template slot-scope="scope">
                            <el-button v-on:click="addressWatch(scope.$index)" type="text">查看</el-button>
                            <el-button type="text">消息</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </div>
                <br><br><br><br><br><br><br><br><br><br><br><br>
            </div>
<!--            查看详情栏-->
            <div v-bind:class="{'hidden':isWatch}">
                <div class="text-left" style="margin-bottom: 1em">
                    <el-button type="text" size="medium" icon="el-icon-back" v-on:click="searchReturn">返回</el-button>
                </div>
                <div>
                    <div class="col-sm-6 col-xs-6 col-xl-6 col-lg-6 text-left personal">
                        <h4>姓名：{{watchData[0].name}}</h4>
                        <h4>部门：{{watchData[0].department}}</h4>
                        <h4>职务：{{watchData[0].post}}</h4>
                    </div>
                    <div class="col-sm-6 col-xs-6 col-xl-6 col-lg-6 text-right personal">
                        <img class="img-circle" src="../../assets/image/test.jpg" height="97" width="97"/>
                    </div>
                </div>
                <div>
                    <div class="col-sm-7 col-xs-7 col-xl-7 col-lg-7 text-left" style="margin-top: 1em">
                        <h4>班级：{{watchData[0].classes}}</h4>
                        <h4>学号：{{watchData[0].num}}</h4>
                        <h4>电话号码：{{watchData[0].tel}}</h4>
                        <h4>QQ：{{watchData[0].qq}}</h4>
                    </div>
                    <div class="col-sm-5 col-xs-5 col-xl-5 col-lg-5 text-right" style="margin-top: 1.6em">
                        <el-button type="primary">发送信息</el-button>
                        <el-button type="success" style="margin-top: 0.5em">复制电话</el-button>
                        <el-button type="success" style="margin-top: 0.5em">复制QQ号</el-button>
                    </div>
                </div>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
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
                    classes: '计科172班',
                    name: '杨旭东',
                    department: 'a',
                    post:'a',
                    tel:'123456789',
                    qq:'123456789',
                    num:'123456789'
                },{
                        classes: '计算机184班',
                        name: '李晨宜',
                        department: 'b',
                        post:'b',
                        tel:'123456789',
                        qq:'123456789',
                        num:'123456789'
                },{
                        classes: '电子183班',
                        name: '杨开元',
                        department: 'c',
                        post:'c',
                        tel:'123456789',
                        qq:'123456789',
                        num:'123456789'
                },{
                        classes: '电气181班',
                        name: '孙国韬',
                        department: 'd',
                        post:'d',
                        tel:'123456789',
                        qq:'123456789',
                        num:'123456789'
                }],
                isWatch:true,
                isSearch:true,
                watchData:[
                    {class: ' ',
                    name: ' ',
                    department: ' ',
                    post:' ',
                    tel:' ',
                    qq:' '}
                    ],
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
                this.watchData = new Array(this.tableData[val])
                // eslint-disable-next-line no-console
                // console.log(val)
                // eslint-disable-next-line no-console
                // console.log(this.watchData)
            },
            searchReturn:function () {
                this.isSearch = false
                this.isWatch = true
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
    .personal{
        background-color: #f2faff;
        padding-top: 1em;
        padding-bottom: 1em;
    }
</style>