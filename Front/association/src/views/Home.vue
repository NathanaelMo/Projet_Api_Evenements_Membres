<template>
  <div>
    <head>
      <meta charset="utf-8">
      <title>Gestion d'événements</title>
    </head>

    <body>
    <header>
      <h1>Gestion d'événements</h1>
    </header>

    <nav>
      <router-link to="/" @click="goPageHome">Accueil</router-link>
      <router-link to="/membres" @click="goPageMembre">Membres</router-link>
      <router-link to="/evenements"@click="goPageEvenement">Evenement</router-link>
      <router-link to="/lieux" @click="goPageLieu">Lieux</router-link>
      <router-link to="/commentaires" @click="goPageCommentaire">Commentaires</router-link>
    </nav>

    <keep-alive>
      <component :is="dynamicComponent"></component>
    </keep-alive>
    </body>
  </div>
</template>

<script>
import Membre from "../components/Membre.vue";
import Commentaire from "../components/Commentaire.vue";
import Evenement from "../components/Evenement.vue";
import Lieu from "../components/Lieu.vue";
import Accueil from "../components/Accueil.vue";

export default {
  data() {
    return {
      dynamicComponent: Accueil
    };
  },
  methods: {
    goPageMembre() {
      this.dynamicComponent = Membre;
    },
    goPageLieu() {
      this.dynamicComponent = Lieu;
    },
    goPageEvenement() {
      this.dynamicComponent = Evenement;
    },
    goPageCommentaire() {
      this.dynamicComponent = Commentaire;
    },
    goPageHome() {
      console.log('goPageHome method called');
      this.dynamicComponent = Accueil;
    }
  }
};
</script>

<style>
@import './style.css';
</style>
