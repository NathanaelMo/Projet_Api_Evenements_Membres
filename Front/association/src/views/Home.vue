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
      <router-link to="/membres">Membres</router-link>
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

<style>
@import './style.css';
</style>
