<template>
    <div>
        <h3>자식 컴포넌트</h3>
        <p>{{myMsg}}</p>
        <p>{{ dynamicProps }}</p>
        <button @click="$emit('someEvent')">클릭</button>
        <button @click="buttonClick">클릭2</button>
        <button @click="emitArgss">추가인자전달</button>
        <ParentGrandChild @update-name="updateNamee" :my-msg="myMsg"/>
    </div>
</template>

<script setup>
import ParentGrandChild from '@/components/ParentGrandChild.vue'
//문자열 배열 형태로 props를 받아서 사용 가능
// defineProps(['myMsg',])
const props = defineProps({
    myMsg: String,
    dynamicProps: String
})
//명시적으로 emit 이벤트들을 정의하겠다.
const emit = defineEmits(["someEvent", 'emitArgs', 'updateName'])

const buttonClick = function () {
    emit("someEvent")
}

const emitArgss = function () {
    emit('emitArgs', 1,2,3)
}

const updateNamee = function (name) {
    emit('updateName', name)
}

console.log(props)
console.log(props.myMsg)


</script>

<style scoped>

</style>