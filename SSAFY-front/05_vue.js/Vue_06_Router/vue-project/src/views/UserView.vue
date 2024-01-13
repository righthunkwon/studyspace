<template>
  <div>
    <h2>UserView</h2>
    <!-- 매개변수 접근방법(1)( $route.params ) -->
    <p>{{ $route.params.id }}</p>
    <!-- 매개변수 접근방법(2)( 권장 - Composition API 방식 ) -->
    <p>{{ userId }}</p>
    <p>{{ userId2 }}</p>

    <hr />

    <button @click="goHome">홈으로</button>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";
import {
  useRoute,
  useRouter,
  onBeforeRouteLeave,
  onBeforeRouteUpdate,
} from "vue-router";

const route = useRoute();
const router = useRouter();

const userId = ref(route.params.id);
const userId2 = ref(route.params.id);

// 프로그래밍 방식 네비게이션
// (1) 다른 위치로 이동하기 : router.push()
//     -> history stack에 push하므로 뒤로 가기 가능

// (2) 현재 위치 바꾸기 : router.replace()
//     -> 이동 전 URL로 뒤로 가기 불가

// 홈 페이지 이동 메서드
const goHome = function () {
  router.push("/");
  //   router.push({ name: "home" });
  //   router.replace("/");
  //   router.replace({ name: "home" });
};

// 실시간으로 데이터 변화를 감지하면서 변경
watch(
  () => route.params.id,
  (newId) => {
    userId2.value = newId;
  }
);

// 컴포넌트 가드
// (1) onBeforeRouteLeave
// 현재 라우터에서 다른 라우터로 이동하기 전에 실행
// 사용자가 현재 페이지를 떠나는 동작에 대한 로직을 처리
onBeforeRouteLeave(() => {
  const answer = confirm("현재 페이지에서 다른 페이지로 이동하시겠습니까?");
  if (!answer) return false; // 취소누르면 반환값은 false
});

// (2) onBeforeRouteUpdate
// 이미 렌더링된 컴포넌트가 같은 라우터 내에서 업데이트 되기 전에 실행
// 라우트 업데이트 시 추가적인 로직을 처리
onBeforeRouteUpdate((to) => {
  userId.value = to.params.id;
});
</script>

<style scoped></style>
