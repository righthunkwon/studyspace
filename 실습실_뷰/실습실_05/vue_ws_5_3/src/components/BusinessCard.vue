<template>
  <div>
    <h3>보유 명함 목록</h3>
    <div class="list">
      <BusinessCardDetail
        v-for="card in businessCards"
        :key="card.name"
        :name="card.name"
        :title="card.title"
        @delete-card-event="deleteCardEvent"
      />
    </div>
  </div>
</template>

<script setup>
import BusinessCardDetail from "@/components/BusinessCardDetail.vue";
import { ref } from "vue";
const businessCards = ref([
  {
    name: "일론 머스크",
    title: "테슬라 테크노킹",
  },
  {
    name: "래리 엘리슨",
    title: "오라클 창업주",
  },
  {
    name: "빌 게이츠",
    title: "마이크로소프트 공동창업주",
  },
  {
    name: "래리 페이지",
    title: "구글 공동창업주",
  },
  {
    name: "세르게이 브린",
    title: "구글 공동창업주",
  },
]);
const deleteCardEvent = function (name) {
  businessCards.value = businessCards.value.filter((c) => c.name !== name);
};
</script>

<style scoped>
h3 {
  margin: 50px auto;
}
.list {
  width: 1000px;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}
</style>
