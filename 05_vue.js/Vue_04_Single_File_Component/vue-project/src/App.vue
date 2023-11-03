<!-- App(부모) -->
<!-- MyComponent(자식)-->
<!-- MyComponentItem(자식의 자식)-->

<!-- 관심사항의 분리는 파일 유형의 분리와 동일하지 않다.-->
<!-- HTML/CSS/JS를 한 파일에 혼합하여 사용 목적에 따라 분리하는 것이 잘 된 관심사항의 분리이다. -->

<!-- vbase-3-setup으로 기본 구조 생성 가능 -->
<template>
  <div>
    <h2>App.Vue</h2>
    <MyComponent></MyComponent>
  </div>
</template>

<script setup>
// ./components/MyComponent.vue -> 상대경로, 현재 폴더 기준
// @/components/MyComponent.vue -> 절대경로, @ = src/
import MyComponent from "./components/MyComponent.vue";
</script>

<style scoped></style>
