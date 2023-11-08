<template>
    <div>
        <h4>TodoList</h4>
        <hr>
        <TodoListItem v-for="todo in store.todos" :key="todo.id" 
            :todo="todo"
        />
    </div>
</template>

<script setup>
import TodoListItem from "./TodoListItem.vue";
import { useTodosStore } from "@/stores/todos";

const store = useTodosStore()


</script>

<style scoped>

</style>