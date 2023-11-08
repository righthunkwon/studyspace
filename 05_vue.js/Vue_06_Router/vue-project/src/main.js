import { createApp } from "vue";
import App from "./App.vue";
import router from "./router"; // /index.js는 생략

const app = createApp(App);

app.use(router);

app.mount("#app");
