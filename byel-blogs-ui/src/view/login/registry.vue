<template>
  <div>
    <bg>
      <template slot="content">
        <el-form ref="form" :model="form" label-width="0" label-position="left" :rules="registerRules">
          <h2>不远尔来注册</h2>
          <el-form-item prop="username">
            <el-input v-model="form.username" placeholder="用户名"></el-input>
          </el-form-item>
          <el-form-item prop="email">
            <el-input v-model="form.email" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="form.password" placeholder="密码" show-password></el-input>
          </el-form-item>
          <el-form-item prop="enPassword">
            <el-input v-model="form.enPassword" placeholder="确认密码" show-password></el-input>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="register">注册</el-button>
            <el-button @click="toLogin">首页</el-button>
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
        email:'',
        enPassword:''
      },
      registerRules:{
        username:[{required: true, message: '必须输入', trigger: 'blur'}],
        email:[{required: true, message: '必须输入', trigger: 'blur'}],
        password:[{required: true, message: '必须输入', trigger: 'blur'}],
        enPassword:[{required: true, message: '必须输入', trigger: 'blur'},
          { validator:(rule,value,callback)=>{
            if (this.form.password!==this.form.enPassword){
              callback('两次输入密码不一致')
            }else {
              console.log(2222)
              callback()
            }
            }, trigger: 'blur' }
        ],

      }
    }
  },
  created() {
  },
  methods: {
    register() {
      this.$refs.form.validate(valid =>{
        if (valid){
          this.loading = true
          this.$store.dispatch('user/register', this.form)
            .then(() => {
              this.$message({
                message: '恭喜你，注册成功',
                type: 'success'
              });
              this.$router.push('/login')
            })
            .catch(() => {
              this.loading = false
            })
        }
      })
    },
    toLogin(){
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
