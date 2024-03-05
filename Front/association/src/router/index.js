import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/Home.vue')
    },
    {
      path: '/commentaires',
      name: 'commentaires',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../components/Commentaire.vue')
    },
    {
      path: '/lieux',
      name: 'Lieux',
      component: () => import('../components/Lieu.vue')
    },
    {
      path: '/membres',
      name: 'Membres',
      component: () => import('../components/Membre.vue')
    },
    {
      path: '/evenements',
      name: 'Evénements',
      component: () => import('../components/Evenement.vue')
    }
  ]
})

export default router
