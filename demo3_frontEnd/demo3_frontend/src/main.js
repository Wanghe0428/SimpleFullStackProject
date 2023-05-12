import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import http from "./util/request.js";
const Vue = createApp(App);
// Vue.prototype.$http = http;
Vue.config.globalProperties.$http = http;
// createApp(App).use(router).mount("#app");
Vue.use(router).mount("#app");
