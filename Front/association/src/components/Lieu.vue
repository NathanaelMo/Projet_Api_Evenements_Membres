<script setup>
 const {ref, onMounted} = require('vue');

  const leLieu = ref({});
  const selectionne = ref(false);
  const lieux = ref([]);

  const selectLocation = (lieu) => {
    leLieu.value = lieu;
    selectionne.value = true;
  };

    onMounted(() => {
    fetch('http://localhost:8080/Projet_Servlet/lieux?operation=listeLieux')
        .then((response) => response.json())
        .then((json) => {
          lieux.value = json;

          // Call selectLocation method with the first location in the list
          if (json.length > 0) {
            selectLocation(json[0]);
          }
        });
  });
 //const app1 = Vue.createApp(Commentaires).mount('#app1')
</script>

<template>
  <div id="pageLieu">
    <main id="app1">
      <h1>Gestion des lieux en Vue</h1>
      <p>Sélectionnez un lieu dans la liste :</p>
      <select v-model="leLieu" style="width:250px">
        <option v-for="lieu in lieux" :value="lieu">
          {{ lieu.nom }}
        </option>
      </select>
      <div v-show="selectionne">
        <p><br/>Editez ses propriétés :</p>
        <table>
          <tr>
            <td>Nom</td>
            <td><input v-model="leLieu.nom"/></td>
          </tr>
          <tr>
            <td>Adresse</td>
            <td><input v-model="leLieu.adresse"/></td></tr>
          <tr><td>Capacité maximale</td><td><input v-model="leLieu.nbMaxPers"/></td></tr>

        </table>
      </div>
      <br />
      <br />
      <h2>Ajouter un nouveau lieu :</h2>
      <form action="lieux?operation=ajouterLieu" method="post">
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

      <form action="lieux?operation=supprimerLieu" method="post">
        <select v-model="leLieu" style="width:250px">
          <option v-for="lieu in lieux" :value="lieu">
            {{ lieu.nom }}
          </option>
        </select>
        <button type="submit">Supprimer</button>
      </form>
    </main>
  </div>
</template>

<style>
@import '../views/style.css';
</style>
