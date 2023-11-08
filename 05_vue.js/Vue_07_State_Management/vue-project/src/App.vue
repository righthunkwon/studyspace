<template>
  <div>
    <h2>Todo PJT</h2>
    <p>완료 Todo : {{ store.doneTodoCount }}</p>
    <TodoForm />
    <TodoList />
  </div>
</template>

<script setup>
// 실습(1)
// import { useCounterStore } from "./stores/counter";

// 실습(2)
import { useTodosStore } from "@/stores/todos";
import TodoForm from "./components/TodoForm.vue";
import TodoList from "./components/TodoList.vue";

const store = useTodosStore();
</script>

<style scoped></style>

<!-- Pinia -->
<!-- Pinia는 store라는 저장소를 가진다. -->
<!-- store는 state, getters, actions로 이루어지며 각각 ref(), computed(), function()과 동일하다. -->

<!-- (1) store -->
<!-- 중앙 저장소, 모든 컴포넌트가 공유하는 상태/기능 등이 작성됨, 여러 저장소 사용 가능 -->

<!-- (2) state -->
<!-- 반응형 데이터(상태, ref()와 유사) -->

<!-- (3) getters -->
<!-- 계산된 값(computed()와 유사) -->

<!-- (4) actions -->
<!-- 메서드(function()과 유사) -->

<!-- (5) plugin -->
<!-- 어플리케이션의 상태 관리에 필요한 추가 기능을 제공하거나 확장하는 도구나 모듈 -->
