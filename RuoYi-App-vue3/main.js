import { createSSRApp } from 'vue'
import App from './App'
import store from './store' // store
import { install } from './plugins' // plugins
import './permission' // permission
import { useDict } from '@/utils/dict'
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

export function createApp() {
  const app = createSSRApp(App)
  app.use(store);
  app.use(ElementPlus);
  app.config.globalProperties.useDict = useDict
  install(app)
  return {
    app
  }
}
