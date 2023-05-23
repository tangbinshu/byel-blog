// import {resolve} from "../../../build/webpack.base.conf";
import { getToken, removeToken, setToken } from '@/utils/auth'
import { getInfo, login, logout } from '@/api/system/profile'
// import permission from './permission'
// import router, { resetRouter } from '@/router'

const state ={
  token: getToken(),
  username:'',
  password:''
}


const  mutations = {
  // SET_TOKEN: (state, token) => {
  //   state.token = token
  // },
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
    return new promise((resolve,reject)=>{
      login({username:username,password:password}).then(
        response=>{
          const {data} = response
          commit('SET_TOKEN',data.token)
          setToken(data.token)
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
