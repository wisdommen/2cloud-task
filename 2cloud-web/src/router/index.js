// Composables
import {createRouter, createWebHistory} from 'vue-router'

const routes = [
  {
    path: '/search',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        // route level code-splitting
        // this generates a separate chunk (Home-[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import('@/views/Home.vue'),
      },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

router.afterEach((to) => {
  const query = to.query
  const prefix = query ? query["make"] + ' ' + query["model"] + ' Used Car Price' : 'Home'
  const suffix = ' | Price People Pay'

  document.title = prefix + suffix
})
export default router
