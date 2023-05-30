<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0;
}


::-webkit-scrollbar {
  width: 10px;
  height: 1px;
}
::-webkit-scrollbar-thumb { //滑块部分
  border-radius: 5px;
  background-color: rgb(74, 190, 240);
}
::-webkit-scrollbar-track { //轨道部分
  box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
  background: #ededed;
  border-radius: 5px;

}
</style>
