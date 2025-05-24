import { createSSRApp } from 'vue'
import App from './App'
import store from './store' // store
import { install } from './plugins' // plugins
import './permission' // permission
import { useDict } from '@/utils/dict'
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import zhCn from 'element-plus/es/locale/lang/zh-cn'; // 引入中文语言包

export function createApp() {
  const app = createSSRApp(App)
  app.use(store);
  app.use(ElementPlus,{locale: zhCn, });
  app.config.globalProperties.useDict = useDict
  install(app)
  return {
    app
  }
}
