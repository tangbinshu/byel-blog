import Vue from 'vue'
import Vuex from 'vuex'
// import getters from './getters'


Vue.use(Vuex)

const getters = {
  username:state => state.user.username,
  password:state => state.user.password,
  token: state => state.user.token
}

//导入modules文件夹下的文件
const modulesFiles = require.context('./modules', true, /\.js$/)

const modules = modulesFiles.keys().reduce((modules, modulePath) => {
  // set './app.js' => 'app'
  const moduleName = modulePath.replace(/^\.\/(.*)\.\w+$/, '$1')
  const value = modulesFiles(modulePath)
  modules[moduleName] = value.default
  return modules
}, {})


const store = new Vuex.Store({
  modules,
  getters
})

export default store
