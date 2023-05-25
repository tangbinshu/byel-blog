import axios from 'axios'
import { Message } from 'element-ui'
import { getToken, setToken } from '@/utils/auth'
import store from '@/store'
import router from '@/router'


const service = axios.create({
   baseURL : 'http://localhost:8080/byel/',
   // baseURL: '/api',
  // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 60000 // request timeout
})
service.interceptors.request.use(
  config => {
    // do something before request is sent
    if (store.getters.token) {
      // let each request carry token
      config.headers['Access-Token'] = getToken()
      if (!config.params) {
        config.params = { currentUser: store.getters.username }
      } else if (config.params['currentUser'] === undefined) {
        config.params['currentUser'] = store.getters.username
      }
    }
    return config
  },
  error => {
    // do something with request error
    console.log(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
service.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
   */

  /**
   * Determine the request status by custom code
   * Here is just an example
   * You can also judge the status by HTTP Status Code
   */
  response => {
    if (response.headers['access-token']) {
      setToken(response.headers['access-token'])
    }
    const res = response.data
    if (res.code !== '0') {
      Message({
        message: res.msg,
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject(new Error(res.msg))
    } else {
      return res
    }
  },
  async error => {
    if (error.response && error.response.status === 406) {
      Message({
        message: '登陆状态失效，请重新登录',
        type: 'error',
        duration: 5 * 1000
      })
      await store.dispatch('user/logout')
      router.push(`/login`)
    } else {
      console.log('err' + error) // for debug
      Message({
        message: error.message,
        type: 'error',
        duration: 5 * 1000
      })
    }
    return Promise.reject(error)
  }
)

export default service
