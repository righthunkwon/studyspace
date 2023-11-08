import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useTodosStore = defineStore('todos', () => {
  let id = 0
  //state
  const todos = ref([
    {id: id++, text: '수업듣기', isDone: false},
    {id: id++, text: '점심먹기', isDone: false},
    {id: id++, text: '춤추기', isDone: false},
  ])
  //actions
  const addTodo = function (text) {
    todos.value.push({
      id: id++,
      text, // == text: text
      isDone: false
    })
  }

  const deleteTodo = function (todoId) {
    const idx = todos.value.findIndex((todo) => { 
      return todo.id === todoId
    })
    // const idx = todos.value.findIndex((todo) => todo.id === todoId)

    todos.value.splice(idx, 1)
  }

  const updateTodo = function (todoId) {
    //아래의 map 함수를 한번 사용해보자 라는 너낌으로 작성을 한거지 무조건 이렇게 해는 아니죠 
    // 알죠?
    todos.value = todos.value.map((todo) => {
      if (todo.id === todoId) {
        todo.isDone = !todo.isDone
      }
      return todo
    })

    //정말 고전 느낌으로다가 아래와같이도 가넝
    // for (let i = 0; i < todos.value.length; i++){

    // }
  }
  const doneTodoCount = computed(() => {
    return todos.value.filter((todo)=> todo.isDone).length
  })


  return { todos, addTodo, deleteTodo, updateTodo, doneTodoCount }
}, {persist: true})
