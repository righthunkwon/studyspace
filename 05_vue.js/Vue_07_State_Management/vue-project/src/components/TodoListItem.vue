<template>
    <div>
        <span class="click-cursor" :class="{ 'is-done': todo.isDone }" @click="store.updateTodo(todo.id)">{{ todo.text
        }}</span>
        <button @click="store.deleteTodo(todo.id)">X</button>
    </div>
</template>

<script setup>
import { useTodosStore } from "@/stores/todos";

const store = useTodosStore();

defineProps({
    todo: Object
})
</script>

<style scoped>
.is-done {
    text-decoration: line-through;
}

.click-cursor {
    cursor: pointer;
}
</style>