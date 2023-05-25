// import {resolve} from "../../../build/webpack.base.conf";
import { getToken, removeToken, setToken } from '@/utils/auth'
import { getInfo, login, logout ,register} from '@/api/system/profile'
// import permission from './permission'
// import router, { resetRouter } from '@/router'
// window.Promise = Promise
const state ={
  token: getToken(),
  username:'',
  password:''
}


const  mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_USERNAME: (state, username) => {
    state.username = username
  },
  SET_PASSWORD: (state, password) => {
    state.password = password
  }
}


const actions ={
  login({commit},userInfo){
    const {username,password} =userInfo
    console.log(userInfo)
    return new Promise((resolve,reject)=>{
      login({username:username,password:password}).then(response=>{

        commit('SET_USERNAME',username)
        commit('SET_PASSWORD',password)

        const { data } = response
        commit('SET_TOKEN',data)
          setToken(data.token)
          localStorage.clear()

          resolve()
        }).catch(error=>{

      reject(error)

      })
    })
  },
  register({commit},userInfo){
    const {username,password,email} =userInfo
    console.log(userInfo)
    return new Promise((resolve,reject)=>{
      register({username:username,password:password,email}).then(response=>{

        commit('SET_USERNAME',username)
        commit('SET_PASSWORD',password)
        localStorage.clear()

        resolve()
      }).catch(error=>{

        reject(error)

      })
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
