// vue-router
// vue-router 로부터 createRouter와 createWebHistory를 구조분해할당
import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import AboutView from "@/views/AboutView.vue";
import UserView from "@/views/UserView.vue";
import LoginView from "@/views/LoginView.vue";
import BoardView from "@/views/BoardView.vue";
import BoardCreate from "@/components/board/BoardCreate.vue";
import BoardList from "@/components/board/BoardList.vue";

// 로그인 유무
const isAuth = true;

// createRouter()
const router = createRouter({
  // createWebHistory()
  history: createWebHistory(import.meta.env.BASE_URL),

  // routes
  // path(URI) & component -> mapping
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/about",
      name: "about",
      component: AboutView,
    },
    {
      path: "/user/:id", // 뷰의 동적 라우팅(:)
      name: "user",
      component: UserView,
    },
    {
      path: "/board",
      name: "board",
      component: BoardView,
      children: [
        {
          path: "",
          component: BoardList,
        },
        {
          path: "create",
          component: BoardCreate,
        },
      ],
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
      beforeEnter: (to, from) => {
        if (isAuth) {
          console.log("이미 로그인한 상태입니다.");
          return { name: "home" };
        }
      },
    },
  ],
});

// 네비게이션 가드
// 뷰 라우터를 통해 특정 URL에 접근할 때
// 다른 URL로 리다이렉트를 하거나 취소하여 네비게이션을 보호

// beforeEach((목적지, 출발지) => {})
router.beforeEach((to, from) => {
  // 이동 확인
  console.log("목적지(to)" + to.fullPath);
  console.log("출발지(from)" + from.fullPath);

  // 네비게이션 가드 활용
  // 로그인 상태가 false인데 login 페이지로 이동하는 것이 아니라면
  if (!isAuth && to.name != "login") {
    console.log("로그인이 필요합니다.");
    return { name: "login" };
  }
});

// router 객체 export
export default router;
