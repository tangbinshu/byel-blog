<template>
  <div class="head-img"></div>
</template>

<script>
export default {
  name: "index",
  created() {
    console.log(this.$store.getters)
  }
}
</script>

<style scoped>
.head-img{
  width: 100%;
  height: 915px;
  background: url('~@/assets/3.jpg') no-repeat;
  margin-top: -60px;
}
</style>
