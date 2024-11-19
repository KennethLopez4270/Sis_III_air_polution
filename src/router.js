import { createRouter, createWebHistory } from 'vue-router';
import Login from './components/Login.vue';
import LayoutPredeterminado from './layouts/LayoutPredeterminado.vue';
import LayoutNoPredeterminado from './layouts/LayoutNoPredeterminado.vue';
import PaginaPrincipal from './components/PaginaPrincipal.vue';
import CienciadeDatos from './components/CienciadeDatos.vue';
import Registro from './components/Registro.vue';
import LayoutDespDeInicio from './layouts/LayoutDespDeInicio.vue';

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
          {
            path: 'registro',
            component: Registro,
          },
          
        ],
      },
      {
        path: '/weka',
        component: LayoutDespDeInicio,
        children: [
          {
            path: 'ciencia-datos',
            component: CienciadeDatos,
          },
        ],
      },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  });
  
  export default router;