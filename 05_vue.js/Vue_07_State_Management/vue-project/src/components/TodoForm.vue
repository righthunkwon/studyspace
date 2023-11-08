<template>
    <div>
        <h4>TodoForm</h4>
        <input type="text" v-model.trim="todoText" @keyup.enter="createTodo">
        <button @click="createTodo">등록</button>
    </div>
</template>

<script setup>
import { useTodosStore } from "@/stores/todos";
import { ref } from 'vue'
const store = useTodosStore()

const todoText = ref('')

const createTodo = function () {
    //가벼운 유효성 검사를 해보자 (꺼억 2번)
    if (todoText.value) {
        store.addTodo(todoText.value)
        todoText.value = ''
    }
    else
        alert('공백은 일이 없는거야')
}
</script>

<style scoped>

</style>