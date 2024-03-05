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
      <button @click="goPageMembre">Membres</button>
      <router-link to="/evenements">Evenement</router-link>
      <router-link to="/lieux">Lieux</router-link>
      <router-link to="/commentaires">Commentaires</router-link>
    </nav>

    <section id="content">
      <router-view></router-view>
    </section>
    </body>
  </div>
</template>

<script>
export default {
  methods: {
    goPageMembre() {
      this.$router.push('/membres');
    },
    navigateToComponentB() {
      this.$router.push('/componentB');
    }
  }
};
</script>
<style>
@import './style.css';
</style>
