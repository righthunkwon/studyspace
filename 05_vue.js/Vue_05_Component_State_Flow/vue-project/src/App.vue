<template>
  <div>
    <h1>최상위(App.vue) 컴포넌트</h1>
    <Parent />
  </div>
</template>

<script setup>
// @ : src의 경로를 나타내는 절대 경로
import Parent from "@/components/Parent.vue";
</script>

<style scoped></style>
