<template>
  <div>
    <bg>
      <template slot="content">
        <el-form ref="form" :model="form" :rules="loginRules" label-width="60px" label-position="left">
          <h2>不远尔来登录</h2>
          <el-form-item label="账号" prop="username">
            <el-input v-model="form.username" placeholder="请输入账号"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
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
import router from "../../router";
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
              if (false) {
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
  padding: 0 20px ;
}

>>> .el-input__inner{
  border: none !important;
  border-bottom: 1px solid rgba(136,136,136,.2) !important;
}
</style>
