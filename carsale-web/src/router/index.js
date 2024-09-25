import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: ()=>import('@/views/login.vue')
  },
  {
    path:'/Index',
    name:'Index',
    component: ()=>import('@/views/homePage.vue'),
    children: [
      {
        // 当 /user/:id/posts 匹配成功
        // UserPosts 将被渲染到 User 的 <router-view> 内部
        path: '/home',
        component: ()=>import("@/components/Main/home.vue"),
      },

      {
        // 当 /user/:id/posts 匹配成功
        // UserPosts 将被渲染到 User 的 <router-view> 内部
        path: '/sale',
        component: ()=>import("@/components/Main/sale.vue"),
      },
      {
        // 当 /user/:id/posts 匹配成功
        // UserPosts 将被渲染到 User 的 <router-view> 内部
        path: '/customer',
        component: ()=>import("@/components/Main/customer.vue"),
      },

      {
        path: '/inventory',
        component:()=>import("@/components/Main/inventory.vue"),
      },


      {
        // 当 /user/:id/posts 匹配成功
        // UserPosts 将被渲染到 User 的 <router-view> 内部
        path: '/form',
        component: ()=>import("@/components/Main/form.vue"),
      },

      {
        // 当 /user/:id/posts 匹配成功
        // UserPosts 将被渲染到 User 的 <router-view> 内部
        path: '/employee',
        component: ()=>import("@/components/Main/employee.vue"),
      },
    ],
  },
  {
    path: '/user',
    name: 'user',
    component: ()=>import('@/views/user.vue')
  },
]

const router = new VueRouter({
  mode: "history",
  routes
})

export default router
