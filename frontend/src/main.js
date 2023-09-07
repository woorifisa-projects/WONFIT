// Components
import App from "./App.vue";

// Composables
import { createApp } from "vue";

// Plugins
import { registerPlugins } from "@/plugins";
import "./styles/global.style.css";

// Import vue-cookies here:
import VueCookies from "vue-cookies";

const app = createApp(App);

app.use(VueCookies); // Add this line to use vue-cookies

registerPlugins(app);

app.mount("#app");
