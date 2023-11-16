<template>
  <div class="py-7 px-10 header-wrapper align-items-center">
    <AppBar/>
  </div>
  <router-view class="content-wrapper" style="background: #f6f4f4"/>
</template>

<script setup>
  //
import AppBar from "@/components/AppBar.vue";
</script>

<style>
@import "@/assets/css/common.css";

</style>
