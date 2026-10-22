import react from "@vitejs/plugin-react";
import { defineConfig } from "vite";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  css: {
    preprocessorOptions: {
      scss: {
        // Tells Sass to ignore deprecation warnings coming from node_modules
        quietDeps: true,
        // Explicitly turns off warnings for the inline if-function change
        silenceDeprecations: ["if-function", "import"],
      },
    },
  },
});
