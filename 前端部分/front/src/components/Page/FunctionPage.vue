<template>
  <div>
<!--    功能主界面-->
    <div class="text-center" v-bind:class="{'hidden':isHidden}">
      <div class="container">
        <div>
          <nav class="navbar navbar-inverse navbar-fixed-top">
            <h1 class="text-center title-font" style="margin-top: 5px;">功能</h1>
          </nav>
        </div>
        <div style="margin-top: 5em">
          <Carousels></Carousels>
        </div>
        <el-divider></el-divider>
        <div class="row">
          <div class="col-lg-2 col-md-2 col-xl-4 col-xs-4 text-center">
            <a v-on:click="showAddressMain">
            <img class="img-thumbnail" style="border: 0" src="../../assets/font/icon_image/icon-test.png"/><br>
            <label style="font-size: 1.5em;font-family: '微软雅黑 Light'">通讯录</label>
            </a>
          </div>
          <div class="col-lg-2 col-md-2 col-xl-4 col-xs-4 text-center">
            <a v-on:click="showProjectMain">
            <img class="img-thumbnail" style="border: 0" src="../../assets/font/icon_image/icon-test_3.png"/><br>
            <label style="font-size: 1.5em;font-family: '微软雅黑 Light'">项目制</label>
            </a>
          </div>
          <div class="col-lg-2 col-md-2 col-xl-4 col-xs-4 text-center">
            <a v-on:click="showTodo_workMain">
            <img class="img-thumbnail" style="border: 0" src="../../assets/font/icon_image/icon-test_2.png"/><br>
            <label style="font-size: 1.5em;font-family: '微软雅黑 Light'">待办事务</label>
            </a>
          </div>
          <div class="col-lg-2 col-md-2 col-xl-4 col-xs-4 text-center">
            <a v-on:click="showWork_progressMain">
            <img class="img-thumbnail" style="border: 0" src="../../assets/font/icon_image/icon-test_4.png"/><br>
            <label style="font-size: 1.5em;font-family: '微软雅黑 Light'">事务进度</label>
            </a>
          </div>
        </div>
      </div>
<!--      十分尴尬，用这种办法 哈哈哈哈哈哈哈哈哈哈哈嗝-->
      <br><br><br><br><br><br><br><br><br><br><br>
    </div>
<!--    通讯录界面-->
    <AddressListPage v-bind:data="addressReturn" v-on:AddressReturn="AddressReturn" v-bind:class="{'hidden':addressHidden}"></AddressListPage>
<!--    项目制界面-->
    <ProjectSystemPage v-bind:data="projectReturn" v-on:ProjectReturn="ProjectReturn" v-bind:class="{'hidden':projectHidden}"></ProjectSystemPage>
<!--    待办事务界面-->
    <Todo_workPage v-bind:data="todo_workReturn" v-on:Todo_workReturn="Todo_workReturn" v-bind:class="{'hidden':todo_workHidden}"></Todo_workPage>
<!--    事务进度界面-->
    <Work_progressPage v-bind:data="work_progressReturn" v-on:Work_progressReturn="Work_progressReturn" v-bind:class="{'hidden':work_progressHidden}"></Work_progressPage>
  </div>
</template>

<script>
  import Carousels from '@/components/Function/Carousels';
  import AddressListPage from "@/components/Function/AddressListPage";
  import ProjectSystemPage from "@/components/Function/ProjectSystemPage";
  import Todo_workPage from "@/components/Function/TodoworkPage";
  import Work_progressPage from "@/components/Function/WorkprogressPage";
  export default {
  name: 'function',
  components:{
    Carousels,AddressListPage,ProjectSystemPage,Todo_workPage,Work_progressPage
  },
    data:function () {
      return {
        isHidden:false,
        addressHidden:true,
        projectHidden:true,
        todo_workHidden:true,
        work_progressHidden:true,
        addressReturn:false,
        projectReturn:false,
        todo_workReturn:false,
        work_progressReturn:false,
      }
    },
    methods:{
    // 通讯录界面显示与隐藏
      showAddressMain:function () {
        this.isHidden = true
        this.addressHidden = false
      },
      AddressReturn:function (val) {
        if(val === true){
          this.isHidden = false
          this.addressHidden = true
          this.addressReturn = false
        }
      },
      // 项目制界面显示与隐藏
      showProjectMain:function () {
        this.isHidden = true
        this.projectHidden = false
      },
      ProjectReturn:function (val) {
        if(val === true){
          this.isHidden = false
          this.projectHidden = true
          this.projectReturn = false
        }
      },
      // 待办事务界面显示与隐藏
      showTodo_workMain:function () {
        this.isHidden = true
        this.todo_workHidden = false
      },
      Todo_workReturn:function (val) {
        if(val === true){
          this.isHidden = false
          this.todo_workHidden = true
          this.todo_workReturn = false
        }
      },
      // 事务进度界面显示与隐藏
      showWork_progressMain:function () {
        this.isHidden = true
        this.work_progressHidden = false
      },
      Work_progressReturn:function (val) {
        if(val === true){
          this.isHidden = false
          this.work_progressHidden = true
          this.work_progressReturn = false
        }
      },
    }
}
</script>


<style scoped>
.title-font{
  font-size: 32px;
  color: white;
  font-family: 微软雅黑;
}
  a,a:hover,a:visited{
    color: #333;
  }
  .hidden{
    display: none;
  }
</style>
