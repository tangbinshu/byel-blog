<template>
  <div class="container">
    <div class="main-image">
      <span class="image-title">不远尔来的blogs</span>
      <img src="@/assets/10.jpg" alt="" style="width: 900px;height: 600px;">
    </div>
    <div class="f_c">
      <slot name="content" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {

    }
  },
  methods: {

  }
}
</script>

<style scoped>
.container {
  position: relative;
  width: 100%;
  overflow: hidden;
  background: linear-gradient(to right,rgb(192 161 91), rgb(226 218 236));
  height:100vh;
}

.main-image{
  position: absolute;
  width: 900px;
  height: 600px;
  margin-top: 150px;
  left: 8%;
  overflow: hidden;
  float: left;
  border-radius: 6px;
}

.f_c{
  position: relative;
  width: 300px;
  max-width: 100%;
  margin: 200px 55%;
  border: 1px ;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  border-radius: 6px;
  overflow: auto;
  background-color: #ffffff;
  opacity: 0.85;
  z-index: 3;
}
.image-title{
  position: absolute;
  left: 50px;
  top: 20px;
  color: white;
  font-size: 25px;
  letter-spacing: 4px;
}
</style>
