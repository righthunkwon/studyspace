<template>
  <div>
    <h2>Todo PJT</h2>
    <p>완료 Todo : {{ store.doneTodoCount }}</p>
    <TodoForm />
    <TodoList />
  </div>
</template>

<script setup>
import { useTodosStore } from "@/stores/todos";
import TodoForm from "./components/TodoForm.vue";
import TodoList from "./components/TodoList.vue";

const store = useTodosStore();

</script>

<style scoped></style>