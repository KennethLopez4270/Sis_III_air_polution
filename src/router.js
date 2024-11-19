import { createRouter, createWebHistory } from 'vue-router';
import Login from './components/Login.vue';
import LayoutPredeterminado from './layouts/LayoutPredeterminado.vue';
import LayoutNoPredeterminado from './layouts/LayoutNoPredeterminado.vue';
import PaginaPrincipal from './components/PaginaPrincipal.vue';

const routes = [
    {
      path: '/',
      component: LayoutPredeterminado,
      children: [
        {
          path: '',
          component: PaginaPrincipal,
        },
      ],
    },
    {
        path: '/auth',
        component: LayoutNoPredeterminado,
        children: [
          {
            path: 'login',
            component: Login,
          },
        ],
      },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  });
  
  export default router;