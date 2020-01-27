<template>
  <div id="app">
    <div>
      <router-view></router-view>
    </div>
    <div class="text-center">
      <div class="container">
        <div class="col-xl-12 col-md-12 col-xs-12 col-sm-12">
          <nav class="navbar navbar-inverse navbar-fixed-bottom">
            <div class="row">
              <div class="col-xs-4 col-sm-4 col-xl-4 col-md-4">
                <router-link to="/message" active-class="index-nav-active" class="index-a index-nav" v-on:click="readMessage">
                  <span class="glyphicon glyphicon-comment nav-font"></span>
                  <div class="notice"  v-bind:class="{'hidden':isMessageRead}"></div>
                  <br>
                  <label>消息</label>
                </router-link>
              </div>
              <div class="col-xs-4 col-sm-4 col-xl-4 col-md-4">
                <router-link to="/function" active-class="index-nav-active" class="index-a index-nav">
                  <span class="glyphicon glyphicon-tasks nav-font"></span><br>
                  <label>功能</label>
                </router-link>
              </div>
              <div class="col-xs-4 col-sm-4 col-xl-4 col-md-4">
                <router-link to="/mine" active-class="index-nav-active" class="index-a index-nav">
                  <span class="glyphicon glyphicon-user nav-font"></span><br>
                  <label>我</label>
                </router-link>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
  data:function() {
  return {
    isMessageRead:false
  };
},
  methods:{
    readMessage:function(){
      this.isMessageRead = true;
    }
  }
}
</script>

<style>
  .nav-font{
    font-size: 32px;
    margin-top: 3%;
  }
  .index-a{
    font-family: 微软雅黑;
    font-size: 16px;
    text-decoration: none;
    outline: none;
  }
  .index-nav{
    color: #acacac;
  }
  .index-nav-active,a:focus, a:hover{
    color: #8fd6fd;
  }
  .notice {
    position: absolute;
    color: white;
    font-family: 微软雅黑;
    background-color:#f00;
    border-radius:100%;
    width: 0.8em;
    height: 0.8em;
    left: 58%;
    top: 3px;
  }
  .hidden{
    display: none;
  }
  .icon {
    width: 1em;
    height: 1em;
    vertical-align: -0.15em;
    fill: currentColor;
    overflow: hidden;
  }
</style>
