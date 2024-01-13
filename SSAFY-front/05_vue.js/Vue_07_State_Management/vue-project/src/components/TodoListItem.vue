<template>
  <div>
    <h4>TodoListItem</h4>
    <span
      class="click-cursor"
      :class="{ 'is-done': todo.isDone }"
      @click="store.updateTodo(todo.id)"
      >{{ todo.text }}</span
    >
    <span class="space-box">&nbsp;&nbsp;</span>
    <button @click="store.deleteTodo(todo.id)">Delete</button>
  </div>
</template>

<script setup>
import { useTodosStore } from "@/stores/todos";

const store = useTodosStore();

defineProps({
  todo: Object,
});
</script>

<style scoped>
.is-done {
  text-decoration: line-through;
}

.space-box {
  width: 20px;
}

.click-cursor {
  cursor: pointer;
}

button {
  cursor: pointer;
  border: 1px solid gray;
  background-color: tomato;
  color: #fff;
}
</style>
