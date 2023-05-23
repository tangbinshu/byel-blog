<template>
  <div>
    <bg>
      <template slot="content">
        <el-form ref="form" :model="form" label-width="0" label-position="left">
          <h2>不远尔来注册</h2>
          <el-form-item>
            <el-input v-model="form.uname" placeholder="用户名"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="form.email" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="form.pwd" placeholder="密码" show-password></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="form.enPwd" placeholder="确认密码" show-password></el-input>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" >注册</el-button>
            <el-button @click="login">首页</el-button>
          </el-form-item>
        </el-form>
      </template>
    </bg>
  </div>
</template>

<script>
import bg from './components/Bg.vue'
export default {
  name: 'Login',
  components: { bg },
  data() {
    return {
      form: {
        uname: '',
        pwd: '',
        email:'',
        enPwd:''
      }
    }
  },
  created() {
  },
  methods: {
    login() {
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
h2{
  letter-spacing: 5px;
  text-align: center;
}
.el-form-item{
  padding: 0 20px ;
}

>>> .el-input__inner{
  border: none !important;
  border-bottom: 1px solid rgba(136,136,136,.2) !important;
}
</style>
