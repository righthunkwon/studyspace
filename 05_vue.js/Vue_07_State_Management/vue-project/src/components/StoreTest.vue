<template>
    <div>
      <h2>StoreTest</h2>
      <p>state : {{ store.count }}</p>
      <p>getters : {{ store.doubleCount }}</p>
      <button @click="store.increment()">증가</button>
      <button @click="incrementt">증가2</button>
    </div>
  </template>
  
  <script setup>
  import { useCounterStore } from '@/stores/counter'
  
  const store = useCounterStore();
  
  console.log(store.count)
  
  const incrementt = function () {
    store.increment()
  }
  
  </script>
  
  <style scoped>
  
  </style>