import { createApp } from "vue";
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";
import App from "./App.vue";

const app = createApp(App);
const pinia = createPinia();

app.use(pinia);
pinia.use(piniaPluginPersistedstate);

app.mount("#app");
