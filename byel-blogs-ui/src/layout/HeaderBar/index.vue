<template>
  <div class="header-div" >
    <div class="head-left">
      不远尔来的blogs
    </div>

    <div class="head-right">
      <div><i class="el-icon-s-home"></i><a href="javascript:void(0);" @click="to('/index/homePage')">首页</a></div>
      <div><i class="el-icon-alarm-clock"></i><a href="javascript:void(0);" @click="to('/index/timer')">时间轴</a></div>
      <div><i class="el-icon-menu"></i><a href="javascript:void(0);" @click="to('/index/classify')">分类</a></div>
      <div><i class="el-icon-s-comment"></i><a href="javascript:void(0);" @click="to('/index/commentArea')">留言区</a></div>
<!--      <div><i class="el-icon-headset"></i><a href="javascript:void(0);" @click="to('/index/musicSpace')">时刻律动</a></div>-->
      <el-dropdown>
  <span class="el-dropdown-link" @click="to('/index/personCenter')">
    <i class="el-icon-user-solid"></i>
 {{username}}
  </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>个人信息</el-dropdown-item>
          <el-dropdown-item>登出</el-dropdown-item>

        </el-dropdown-menu>
      </el-dropdown>
    </div>

  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      username:this.$store.getters.username


    }
  },
  methods:{
    to(path) {
      this.$router.push(path)
    }
  }
}
</script>

<style scoped>
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}

.header-div{
  position: relative;
  width: 100%;
  height: 60px;
  text-align: right;
  font-size: 12px;
  opacity: 0.8;
}

.head-left{
  color: white;
  position: absolute;
  font-size: 15px;
  line-height: 60px;
  letter-spacing: 5px;
  left: 50px;
}

.head-right{
  position: absolute;
  font-size: 15px;
  line-height: 60px;
  right: 50px;
  display: flex;
  font-weight: 300;
}

.head-right div {
  line-height: 60px;
  height: 45px;
  background: linear-gradient(to right, #dc8d54, #ffffff) no-repeat left bottom;
  background-size: 0 3px;
  transition: background-size 1300ms;
  margin-right: 15px;
}
.head-right div:hover{
  background-size: 100% 2px;
}
.head-right i {
  color: white;
  margin-right: 3px;
}
.head-right a{
  text-decoration: none;
  color: white;

}

.el-dropdown-link{
  color: white;

}

.el-icon-s-home{
  margin-right: 2px;
  color: white;
}
</style>
