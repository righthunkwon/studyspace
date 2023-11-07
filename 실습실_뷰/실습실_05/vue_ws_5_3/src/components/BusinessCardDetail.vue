<template>
  <div class="card">
    <h4>이름: {{ name }}</h4>
    <p>직함: {{ title }}</p>
    <button @click="deleteCardEvent">명함 삭제</button>
  </div>
</template>

<script setup>
const props = defineProps({
  name: String,
  title: String,
});
const emit = defineEmits(["deleteCardEvent"]);
const deleteCardEvent = function () {
  emit("deleteCardEvent", props.name);
};
</script>

<style scoped>
.card {
  margin: 20px;
  padding: 10px;
  border: 1px solid lightgray;
  background-color: rgb(243, 242, 242);
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 400px;
}
</style>
