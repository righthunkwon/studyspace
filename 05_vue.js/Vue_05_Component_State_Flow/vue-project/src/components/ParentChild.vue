<template>
  <div>
    <h3>자식 컴포넌트</h3>
    <p>{{ myMsg }}</p>
    <p>{{ dynamicProps }}</p>

    <!-- Emit(1) -->
    <button @click="$emit('someEvent')">클릭1</button>
    <!-- Emit(2) -->
    <button @click="buttonClick">클릭2</button>

    <!-- Emit 인자 전달-->
    <button @click="emitArgs">추가인자전달</button>

    <ParentGrandChild :my-msg="myMsg" @update-name="updateName" />
  </div>
</template>

<script setup>
import ParentGrandChild from "@/components/ParentGrandChild.vue";

// Props 선언 방법
// (1) 문자열 배열 사용 : defineProps(['prop1', 'prop2', ... ])
// (2) 객체 사용 : defineProps({prop1: Type, prop2: Type, ... })

// (1) 문자열 배열 형태로 Props 선언
// const props = defineProps([myMsg, dynamicProps]);

// (2) 객체 형태로 Props 선언
// key는 props의 이름, value는 props의 타입
// 문자열 배열보다는 객체 선언 문법 사용이 권장
const props = defineProps({
  myMsg: String,
  dynamicProps: String,
});
console.log(props); // Proxy 객체

// Props Name Casing
// 선언 및 템플릿 참조 시 : camelCase
// 자식 컴퐅넌트로 전달 시 : kebab-case

// Emit 선언 방법
// defineEmits(['emit1', 'emit2', ... ])
// emit() : 자식 컴포넌트가 이벤트를 발생시켜 부모 컴포넌트로 데이터를 전달하는 메서드
const emit = defineEmits(["someEvent", "emitArgs", "updateName"]);

const buttonClick = function () {
  emit("someEvent");
};

const emitArgs = function () {
  emit("emitArgs", 9, 6, 0, 6, 1, 7);
};

const updateName = function (name) {
  emit("updateName", name);
};
</script>

<style scoped></style>
