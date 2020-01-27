import Vue from 'vue'
import VueRouter from 'vue-router'
import hello from '@/components/HelloWorld'
import functions from '@/components/Page/FunctionPage'
import message from '@/components/Page/MessagePage'
import mine from '@/components/Page/MinePage'

Vue.use(VueRouter)

export default new VueRouter({
    mode: 'history',
    //配置多个路由
    routes:[
        {
            path:'/',
            component:hello
        },
        {
            path:'/message',
            component:message
        },
        {
            path:'/mine',
            component:mine
        },
        {
            path:'/function',
            component:functions
        }
    ]
})
