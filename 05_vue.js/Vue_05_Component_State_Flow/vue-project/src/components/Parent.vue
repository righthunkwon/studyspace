<template>
    <div>
        <h2>부모 컴포넌트</h2>
        <input type="text" v-model="name"> 
        <ParentChild @update-name="updateNamee" @emit-args="getNumber" @some-event="someCallBack" my-msg="message123" :dynamic-props="name"/>
    </div>
</template>

<script setup>
import {ref} from 'vue'
import ParentChild from "@/components/ParentChild.vue";

const name = ref('Alice')

const someCallBack = function () {
    console.log('자식컴포넌트의 이벤트를 수신했습니다.')
}
const getNumber = function (...args) {
    console.log(args)
}
const updateNamee = function (newName) {
    name.value =  newName
}

</script>

<style scoped>

</style>