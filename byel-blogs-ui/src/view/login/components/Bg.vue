<template>
  <div class="container">
    <div class="main-image">
      <img src="@/assets/blue.jpg" alt="" style="width: 900px;height: 600px;">
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
  background: linear-gradient(to right,rgb(5 3 0), rgb(79 23 150));
  height:100vh;
}

.main-image{
  position: absolute;
  width: 900px;
  height: 600px;
  background-color: yellow;
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

</style>
