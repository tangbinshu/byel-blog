<template>
<div>
  <el-form ref="form" :model="form" label-width="60px" label-position="left" class="f_c">
    <h2>不远尔来登录</h2>
    <el-form-item label="账号">
      <el-input v-model="form.uname" placeholder="请输入账号"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="form.pwd" placeholder="请输入密码" show-password></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="onSubmit">登录</el-button>
      <el-button>注册</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
export default {
  name: "loginForm",
  created() {
    this.$message.info("bbbbb")
  }

}
</script>

<style scoped>
.f_c{
  position: relative;
  width: 400px;
  max-width: 100%;
  margin: 200px 50%;
  border: 1px ;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  border-radius: 6px;
  overflow: auto;
  background-color: #ffffff;
  opacity:0.7;
  z-index: 3;


}
</style>
