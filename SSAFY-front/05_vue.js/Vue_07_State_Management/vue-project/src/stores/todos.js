import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useTodosStore = defineStore(
  "todos",
  () => {
    // state
    let id = 0;
    const todos = ref([
      { id: id++, text: "수업듣기", isDone: false },
      { id: id++, text: "점심먹기", isDone: false },
      { id: id++, text: "춤추기", isDone: false },
    ]);
    // actions
    // action(1)
    const addTodo = function (todoText) {
      todos.value.push({
        id: id++,
        text: todoText,
        isDone: false,
      });
    };

    // action(2)
    const deleteTodo = function (todoId) {
      const idx = todos.value.findIndex((todo) => {
        return todo.id === todoId;
      });
      todos.value.splice(idx, 1);
    };

    // action(3)
    const updateTodo = function (todoId) {
      // Array.prototype.map()
      // map() 메서드는 배열 내의 모든 요소 각각에 대하여
      // 주어진 함수를 호출한 결과를 모아 새로운 배열을 반환합니다.
      todos.value = todos.value.map((todo) => {
        if (todo.id === todoId) {
          todo.isDone = !todo.isDone;
        }
        return todo;
      });
    };

    // action(4)
    const doneTodoCount = computed(() => {
      // filter
      // 참인 요소들로만 새로운 배열을 만든다.
      return todos.value.filter((todo) => todo.isDone).length;
    });

    return { todos, addTodo, deleteTodo, updateTodo, doneTodoCount };
  },
  { persist: true }
);
