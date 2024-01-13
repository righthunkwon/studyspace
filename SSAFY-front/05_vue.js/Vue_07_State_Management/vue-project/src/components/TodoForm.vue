<template>
  <div>
    <h4>TodoForm</h4>
    <!-- v-model.trim: 양방향 바인딩, 공백 제거 -->
    <!-- @keyup.enter: 엔터 입력 시 실행 -->
    <input type="text" v-model.trim="todoText" @keyup.enter="createTodo" />
    <span class="space-box">&nbsp;&nbsp;</span>
    <button @click="createTodo">Create</button>
  </div>
</template>

<script setup>
import { useTodosStore } from "@/stores/todos";
import { ref } from "vue";

const store = useTodosStore();

const todoText = ref("");

const createTodo = function () {
  // 유효성 검사
  // 아무것도 입력하지 않을 경우에는 등록되지 않는다.
  // 빈 문자열은 false처리 하므로 빈 문자열이 들어올 경우에는 실행되지 않는다.
  if (todoText.value) {
    store.addTodo(todoText.value);
    todoText.value = "";
  } else {
    alert("공백은 등록할 수 없습니다.");
  }
};
</script>

<style scoped>
button {
  cursor: pointer;
  border: 1px solid gray;
  background-color: cornflowerblue;
  color: #fff;
}
</style>
