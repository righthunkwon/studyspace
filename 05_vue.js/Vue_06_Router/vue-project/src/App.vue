<!-- 라우팅 -->
<!-- 네트워크에서 경로를 선택하는 프로세스 -->
<!-- URI를 부여하거나 변경해주는 기능을 수행 -->

<!-- 디렉토리 구조 -->
<!-- (1) components : 렌더링할 기본 컴포넌트를 배치 -->
<!-- (2) views : RouterView 위치에 렌더링할 컴포넌트를 배치, 기능적으로 components와 동일 -->

<template>
  <div>
    <h1>AppVue</h1>
    <header>
      <!-- RouterLink: <a></a> tag -->
      <!-- (1) RouterLink 방식 -->
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">About</RouterLink>

      <!-- (2) Named Routes 방식(v-bind 활용) -->
      <RouterLink :to="{ name: 'home' }">HomeName</RouterLink>
      <RouterLink :to="{ name: 'about' }">AboutName</RouterLink>

      <!-- (3) 매개 변수를 사용한 동적 경로 매칭 방식 -->
      <RouterLink :to="{ name: 'user', params: { id: 'kwon' } }"
        >권정훈</RouterLink
      >
      <RouterLink :to="{ name: 'user', params: { id: 'ssafy' } }"
        >김싸피</RouterLink
      >
      <RouterLink :to="{ name: 'login' }">login</RouterLink>
      <RouterLink to="/board">게시판</RouterLink>
    </header>
    <RouterView></RouterView>
  </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
</script>

<style scoped>
header {
  display: flex;
  justify-content: space-around;
}

a {
  text-decoration: none;
}
</style>
