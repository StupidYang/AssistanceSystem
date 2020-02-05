import qs from "qs";
import Vue from 'vue'
// 因为异步请求一般会写在store里面，这样就需要用到this，但实际this就是vue对象的内容
// 很可能其他组件功能会失效，一般其他功能写在那个文件中

export default {
    state: {
        isLogin:false,
        user:{
            username:'',
            classes: '',
            name: '',
            department: '',
            post:'',
            tel:'',
            qq:'',
            num:'',
            power:'',
        }
    },
    mutations: {
        // state的变量只能由这里的函数来改变，同时也需要action来调用
        login (state, payload) {
            state.isLogin = true
            state.user.username = payload.username
        },
        getUserInformation(state, payload){
            state.user.name = payload.name
            state.user.department = payload.department
            state.user.post = payload.post
            state.user.tel = payload.tel
            state.user.qq = payload.qq
            state.user.num = payload.num
            state.user.power = payload.power
        }
    },
    actions:{
        // 登陆
        login(context, payload){
            return new Promise((resolve, reject) => {
                Vue.axios.post('/api/login',qs.stringify(payload))
                    .then(function(response) {
                        if(response.data.code === 200){
                            // 登陆成功
                            resolve(response)
                            // 这里的'login'是mutation的login
                            // 不用payload，也可以自定义一个json比如{username:xxx,xxx:xxx}
                            context.commit('login', payload)
                        }else {
                            // 登陆失败
                            reject(response)
                        }
                    })
                    // eslint-disable-next-line no-unused-vars
                    .catch(function (error) {
                        // 服务器出现问题，也是登陆失败
                        error.data = {
                            message: '服务器被暂时拿去发电了，刷新一下它马上就被拿回来！'
                        }
                        reject(error)
                    })
            })
        },
        // 获取个人信息
        getUserInformation(context, payload){
            return new Promise((resolve, reject) => {
                Vue.axios.post('/api/getUserInformation',qs.stringify(payload))
                    .then(function (response) {
                        if(response.data === "找不到该用户，请确认后输入" ){
                            reject(response)
                        }else {
                            var user = JSON.stringify(response.data)
                            context.commit('getUserInformation', user)
                            resolve(response)
                        }
                    })
            })
        }
    },
    getters:{
        getUsername(state){
            return state.user.username
        },
        getName(state){
            return state.user.name
        },
        getClasses(state){
            return state.user.classes
        },
        getPost(state){
            return state.user.post
        },
        getTel(state){
            return state.user.tel
        },
        getDepartment(state){
            return state.user.department
        },
        getQQ(state){
            return state.user.qq
        },
        getNum(state){
            return state.user.num
        },
        getPower(state){
            return state.user.power
        },
        getIsLogin(state){
            return state.isLogin
        }
    }
}