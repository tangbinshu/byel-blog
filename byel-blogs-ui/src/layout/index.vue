<template>
  <el-container>
    <el-header >
      <header-bar :class="headBarClass" style="position: fixed ; width: 100%;overflow: hidden" />
    </el-header>

    <div class="main">
      <main-page />
    </div>

   <back-top></back-top>



  </el-container>

</template>

<script>
import HeaderBar from "./HeaderBar/index.vue";
import MainPage from "./MainPage/index.vue";
import BackTop from "./BackTop/index.vue";
export default {
  name: "index.vue",
  components: {
    HeaderBar,
    MainPage,
    BackTop
  },
  data() {
    return {
      headBarClass: ''
    }
  },
  computed: {

  },
  mounted(){
    window.addEventListener('scroll', this.handleScroll, true)
  },
  methods:{
    handleScroll() {
      this.headBarClass = window.scrollY > 0 ? 'header-bg' : ''
    }
  }


}
</script>

<style scoped>

.el-container{
  position: relative;
  width: 100%;
  height: 100%;
  background-size: cover;
  background: url("../assets/brage2.jpg") no-repeat fixed;
}
.el-header{
  width: 100%;
  padding: 0 0;
}



.header-bg{
  background:linear-gradient(to right, #5ab886 10%, #2881b8 90%);
  opacity: 0.8;
}

body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

</style>
