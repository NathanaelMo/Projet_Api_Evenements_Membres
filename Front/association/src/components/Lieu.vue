<script setup>
import {ref, onMounted, watch, reactive} from 'vue'

  const leLieu = ref(null);
  const selectionne = ref(false);
  const lieux = ref([]);
  const idLieuInput = ref(null);
  const lieuParId= ref([]);

const state = reactive({
  leLieuId: null,
  leLieu: {},
});

  onMounted(() => {
    fetch('http://localhost:8080/Projet_Servlet/lieux?operation=listeLieux')
        .then((response) => response.json())
        .then((json) => {
          lieux.value = json;
        });
  });

  watch(leLieu, (nouvelleValeur, ancienneValeur) => {
    selectionne.value = true;
  });

  const getLieuParId = () => {
    const id_lieu = idLieuInput.value.value;
    console.log(id_lieu);
      fetch(`http://localhost:8080/Projet_Servlet/lieux?operation=getLieuParId&id_lieu=${id_lieu}`)
          .then((response) => response.json())
          .then((json) => {lieuParId.value = json});
  }

console.log("Lieux récupérés")
//const app3 = Vue.createApp(Commentaires).mount('#app3')
</script>

<template>
  <div id="pageLieu">
    <main id="app1">
      <h1>Gestion des lieux en Vue</h1>
      <p>Sélectionnez un lieu dans la liste pour voir ses propriétés:</p>
      <select ref="leLieu" v-model="state.leLieu" style="width:250px">
        <option v-for="lieu in lieux" :value="lieu">
          {{ lieu.nom }}
        </option>
      </select>
      <div v-show="selectionne">
        <p><br/>Propriétés du lieu :</p>
        <br />
        <table>
          <tr>
            <td>Nom: </td>
            <td>{{ state.leLieu.nom }}</td>
          </tr>
          <tr>
            <td>Adresse: </td>
            <td>{{ state.leLieu.adresse }}</td></tr>
          <tr><td>Capacité maximale: </td>
            <td>{{ state.leLieu.nbMaxPers }}</td></tr>

        </table>
      </div>
      <br />
      <br />
      <h2>Ajouter un nouveau lieu :</h2>
      <form action="http://localhost:8080/Projet_Servlet/lieux?operation=ajouterLieu" method="post">
        <label for="nom">Nom du lieu:</label>
        <input type="text" id="nom" name="nom" required><br>
        <br />
        <label for="adresse">Adresse:</label>
        <input type="text" id="adresse" name="adresse" required><br>
        <br />
        <label for="nbMaxPers">Nombre maximal de personnes:</label>
        <input type="number" id="nbMaxPers" name="nbMaxPers" required><br>
        <br />
        <button type="submit">Ajouter</button>
      </form>
      <br />
      <br />
      <h2>Supprimer un lieu</h2>

      <form action="http://localhost:8080/Projet_Servlet/lieux?operation=supprimerLieu" method="post">
        <label for="id">Id:</label>
        <input type="text" id="id" name="id" required><br>
        <br />
        <button type="submit">Supprimer</button>
      </form>

      <br />
      <h2>Afficher le lieu d'id:</h2>
      <form>
        <label for="id_lieu">Id:</label>
        <input ref="idLieuInput" type="text" id="id_lieu" name="id_lieu" v-model="id_lieu" required><br>
        <br />
        <button @click.prevent="getLieuParId">Chercher</button><br />
      </form>
      <div v-for="lieu in lieuParId" :key="lieu.id_lieu">
        <p>lieu : {{ lieu.nom }}</p>
      </div>
    </main>
  </div>
</template>

<style>
@import '../views/style.css';
</style>
