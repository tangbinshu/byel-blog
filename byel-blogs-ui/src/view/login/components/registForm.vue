<template>
<div>
  <el-form ref="form" :model="form" label-width="60px" label-position="left" class="f_c">
    <h2>不远尔来</h2>
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
  name: "registerForm"
}
</script>

<style scoped>

</style>
