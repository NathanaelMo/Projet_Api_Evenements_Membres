<script setup>
const { ref, onMounted, computed } = require('vue');

const auteur = ref('Charlotte');
const Evenements = ref([]);

const nbEvenements = computed(() => {
  return Evenements.value.length;
});

onMounted(() => {
  fetch('http://localhost:8080/Projet_Servlet/Evenements?operation=listeEvenements')
      .then((response) => response.json())
      .then((json) => {
        Evenements.value = json;
      });
});
const app2 = Vue.createApp(Evenements).mount('#app4')
</script>

<template>
  <!-- /////////////////////////////////////////////Evenement///////////////////////////////////////////////////////////// -->
  <div id="pageEvenement" style="display:none;">
    <main id="app4">
      <p>Il y a {{ nbEvenements }} Evenements dans la base.</p>
      <div v-for="Evenement in Evenements" :key="Evenement.id_evenement">
        <p>Nom de l'événement : {{ Evenement.nom }}</p>
        <p>Id evenement : {{ Evenement.id_evenement }}</p>
        <p>Date de l' événement : {{ Evenement.date }}</p>
        <p>Durée de l' événement : {{ Evenement.duree }}</p>

      </div>
      <br />
      <br />
      <h2>Ajouter un nouveau Evenement :</h2>
      <form action="Evenements?operation=ajouterEvenement" method="post">
        <label for="nom">Nom de l'événement :</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="date">Date de l'événement :</label>
        <input type="date" id="date" name="date" required><br>

        <label for="duree">Durée en jours :</label>
        <input type="number" id="duree" name="duree" min="1" required>1<br>

        <label for="nb_participant">Nombre de participant maximum :</label>
        <input type="number" id="nb_participant" name="nb_participant" min="1" required>1<br>
        <br />
        <!-- TODO rajouter une liste qui permet sélectionner le lieu de l'évenement -->
        <button type="submit">Ajouter</button>
      </form>
      <br />
      <br />
      <h2>Supprimer un Evenement</h2>
      <form action="Evenements?operation=supprimerEvenement" method="post">
        <label for="id_message">Id:</label>
        <input type="text" id="id_message" name="id_message" required><br>
        <br />
        <button type="submit">Supprimer</button>
      </form>
    </main>
  </div>
</template>

<style>
@import '../views/style.css';
</style>
