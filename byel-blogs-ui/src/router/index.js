import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/view/login'
import Registry from '@/view/login/registry.vue'
import layout from "@/layout/index.vue"

import HomePage from '@/view/HomePage/index'

import TimerShaft from '@/view/TimerShaft/index'

import Classify from '@/view/Classify/index'

import MusicSpace from '@/view/MusicSpace/index'

import PersonCenter from '@/view/PersonCenter/index'

import CommentArea from '@/view/CommentArea/index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/registry',
      name: 'Registry',
      component: Registry
    },
    {
      path: '/index',
      name: 'index',
      component: layout,
      children: [
        {
          path: 'homePage',
          component:HomePage,
          name: 'homePage'
        },
        {
          path: 'timer',
          component:TimerShaft,
          name: 'timer'
        },
        {
          path: 'classify',
          component:Classify,
          name: 'Classify'
        },
        {
          path: 'musicSpace',
          component:MusicSpace,
          name: 'MusicSpace'
        },
        {
          path: 'personCenter',
          component:PersonCenter,
          name: 'PersonCenter'
        },
        {
          path: 'commentArea',
          component:CommentArea,
          name: 'CommentArea'
        }
      ]
    }
  ]
})
