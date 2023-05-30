<template>
  <div>
    <bg>
      <template slot="content">
        <el-form ref="form" :model="form" :rules="loginRules" label-width="0" label-position="left">
          <h2>不远尔来登录</h2>
          <el-form-item  prop="username">
            <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item  prop="password">
            <el-input v-model="form.password" placeholder="请输入密码" show-password></el-input>
          </el-form-item>

          <el-form-item>
            <el-button :loading="loading" type="primary" @click="onSubmit">登录</el-button>
            <el-button @click="registry">注册</el-button>
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
        username: '',
        password: '',
      },
      loginRules:{
        username:[{required: true, message: '必须输入', trigger: 'blur'}],
        password:[{required: true, message: '必须输入', trigger: 'blur'},
          { validator: (rule, value, callback) => {
              if (this.form.password.length<5) {
                callback(new Error('密码必须超过六位'))
              } else {
                callback()
              }
            }, trigger: 'blur' }
        ]
      },
      loading:false,
      redirect: undefined,
      otherQuery: {}
    }
  },
  created() {
  },
  methods: {
    registry() {
      this.$router.push('/registry')
    },
    onSubmit() {
      this.$refs.form.validate(valid =>{
        if (valid){
          this.loading = true
          this.$store.dispatch('user/login', this.form)
            .then(() => {
              this.$message({
                message: '登陆成功',
                type: 'success'
              });
              this.$router.push('/index/homePage')
            })
            .catch(() => {
              this.loading = false
            })
        }
      })
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
  padding: 8px 20px ;
}

>>> .el-input__inner{
  border: none !important;
  border-bottom: 1px solid rgba(136,136,136,.2) !important;
}
.el-button{
  width: 90px;
}
.el-form el-form--label-left{
  height: 330px;
}
</style>
