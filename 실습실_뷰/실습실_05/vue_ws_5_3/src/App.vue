<template>
  <div class="container">
    <h1>명함 관리 페이지</h1>
    <p>명함을 관리하는 페이지입니다. 여기에 명함 목록이 표시됩니다.</p>
    <BusinessCard />
    <div class="footer">
      &copy; 2023 My Business Card
      </div>
  </div>
</template>

<script setup>
import BusinessCard from "@/components/BusinessCard.vue";
</script>

<style scoped>
.container {
  text-align: center;
}
h1 {
  width: 30%;
  height: 120px;
  margin: 0 auto;
  line-height: 120px;
  color: white;
  background-color: rgb(48, 80, 170);
}
.footer{
  margin-top: 200px;
  background-color: rgb(243, 242, 242);
  text-align: center;
  font-size: 13px;
  line-height: 50px;
}
</style>
