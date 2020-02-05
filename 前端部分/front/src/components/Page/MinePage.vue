<template>
  <div>
<!--    我的主界面-->
    <div>
      <div class="container">
        <div>
          <nav class="navbar navbar-inverse navbar-fixed-top">
            <h1 class="text-center title-font" style="margin-top: 5px;">我</h1>
          </nav>
        </div>
<!--        个人信息-->
        <div style="margin-top: 5em" class="row" v-bind:class="{'hidden':!isLogin}">
          <div class="col-sm-6 col-xs-6 col-xl-6 col-lg-6 personal">
            <h4>姓名：{{name}}</h4>
            <h4>部门：{{department}}</h4>
            <h4>职务：{{post}}</h4>
          </div>
          <div class="col-sm-6 col-xs-6 col-xl-6 col-lg-6 text-right personal">
            <img class="img-circle" src="../../assets/image/test.jpg" height="97" width="97"/>
          </div>
        </div>
<!--          未登录时-->
          <div style="margin-top: 5em" class="row" v-bind:class="{'hidden':isLogin}">
              <div class="col-sm-6 col-xs-6 col-xl-6 col-lg-6 personal" style="padding-top: 41px;padding-bottom: 41px;">
                  <el-button @click="dialogFormVisible = true" type="text" style="font-size: 1.25em;padding-left: 1.5em">点击登陆</el-button>
              </div>
              <div class="col-sm-6 col-xs-6 col-xl-6 col-lg-6 text-right personal">
                  <img class="img-circle" src="../../assets/image/unlogin.jpg" height="97" width="97"/>
              </div>
          </div>
<!--          点击登录-->
          <el-dialog title="账号登陆" :visible.sync="dialogFormVisible" width="80%">
              <el-form :model="form">
                  <el-form-item label="账号">
                      <el-input v-model="form.username" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="密码">
                      <el-input type="password" v-model="form.password" autocomplete="off"></el-input>
                  </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="dialogFormVisible = false">取 消</el-button>
                  <el-button type="primary" @click="userLogin">登陆</el-button>
              </div>
          </el-dialog>
<!--          菜单-->
        <el-divider></el-divider>
        <div>
            <li style="margin-top: 0.25em"><el-button icon="el-icon-setting" type="primary" plain style="width: 100%">账号管理</el-button></li>
            <li style="margin-top: 0.25em"><el-button icon="el-icon-user" type="primary" plain style="width: 100%">个人信息修改</el-button></li>
            <li style="margin-top: 0.25em"><el-button icon="el-icon-mobile-phone" type="primary" plain style="width: 100%">修改头像</el-button></li>
            <li style="margin-top: 0.25em"><el-button icon="el-icon-edit" type="primary" plain style="width: 100%">反馈与建议</el-button></li>
            <li style="margin-top: 0.25em"><el-button icon="el-icon-switch-button" type="primary" plain style="width: 100%">退出登录</el-button></li>
        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'mine',
  data:function () {
      return{
          dialogTableVisible: false,
          dialogFormVisible: false,
          form: {
              username: '',
              password: '',
          },
      };
  },
  methods:{
      userLogin:function () {
          var self = this;
          self.dialogFormVisible = false;
          // 通过dispath调用login-store中的login action
          self.$store.dispatch('login', {username: self.form.username, password: self.form.password})
          .then((response) => {
              //登陆成功，then获取到reslove
              self.$message.success(response.data.message + '亲爱的' + this.name + '，欢迎回来！')
              //获取全部个人信息
              self.$store.dispatch('getUserInformation',{username: self.form.username})
              .then((response) => {
                  // 获取成功
                  response.data = null

              })
              .catch((response) => {
                  // 获取失败
                  self.$message.error(response.data)
              })
          })
          .catch((response) =>{
              //登陆失败，catch获取到reject
              self.$message.error(response.data.message)
          })
      }
  },
  computed:{
      username:function () {
          return this.$store.getters.getUsername
      },
      isLogin:function () {
          return this.$store.getters.getIsLogin
      },
      name:function () {
          return this.$store.getters.getName
      },
      department:function () {
          return this.$store.getters.getDepartment
      },
      post:function () {
          return this.$store.getters.getPost
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
  .personal{
    background-color: #ebecf2;
    padding-top: 1em;
    padding-bottom: 1em;
  }
li {
    list-style-type: none;
  }
</style>
