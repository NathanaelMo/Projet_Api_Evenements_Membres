import { createRouter, createWebHistory } from 'vue-router'

import Home from '../views/Home.vue';
import Membres from '../components/Membre.vue';
import Evenements from '../components/Evenement.vue';
import Lieux from '../components/Lieu.vue';
import Commentaires from '../components/Commentaire.vue';
import Accueil from "@/components/Accueil.vue";


const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Accueil
    },
    {
      path: '/commentaires',
      name: 'commentaires',
      component: Commentaires
    },
    {
      path: '/lieux',
      name: 'Lieux',
      component: Lieux
    },
    {
      path: '/membres',
      name: 'Membres',
      component: Membres
    },
    {
      path: '/evenements',
      name: 'Evénements',
      component: Evenements
    }
  ]
})


export default router
