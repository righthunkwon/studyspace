<template>
  <div>
    <h4>손자 컴포넌트</h4>
    <p>{{ myMsg }}</p>
    <input type="text" v-model="name" />
    <button @click="updateName">이름 변경</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
defineProps({
  myMsg: String,
});

const emit = defineEmits(["updateName"]);
const name = ref("");
const updateName = function () {
  emit("updateName", name.value);
};
</script>

<style scoped></style>
