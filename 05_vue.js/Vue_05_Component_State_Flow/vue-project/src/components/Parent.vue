<!-- Passing Props -->
<!-- 부모는 자식에게 데이터를 전달(Pass Props)하며, -->
<!-- 자식은 자식에게 일어난 일을 부모에게 알린다(Emit events) -->
<!-- 부모는 자식에게 하향식 단방향 바인딩을 통해 데이터를 전달한다. -->
<!-- 즉, 부모속성이 업데이트 되면 자식으로 흐르지만 그 반대는 되지 않는다. -->

<!-- template -->
<template>
  <div>
    <h2>부모 컴포넌트</h2>
    <input type="text" v-model="name" />
    <ParentChild
      my-msg="my-message"
      :dynamic-props="name"
      @update-name="updateName"
      @emit-args="getNumber"
      @some-event="someCallBack"
    />
  </div>
</template>

<!-- script -->
<script setup>
import { ref } from "vue";
import ParentChild from "@/components/ParentChild.vue";

const name = ref("Alice");

const someCallBack = function () {
  console.log("자식컴포넌트의 이벤트를 수신했습니다.");
};
const getNumber = function (...args) {
  console.log(args);
};
const updateName = function (newName) {
  name.value = newName;
};
</script>

<!-- style -->
<style scoped></style>
