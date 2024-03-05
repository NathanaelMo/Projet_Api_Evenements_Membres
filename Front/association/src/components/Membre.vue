<script setup>
import { ref, onMounted, computed } from 'vue';

const auteur = ref('Charlotte');
const leMembre = ref(null);
const Membres = ref([]);

const nbMembres = computed(() => {
  return Membres.value.length;
});

onMounted(() => {
  fetch('http://localhost:8080/Projet_Servlet/Membres?operation=listeMembres')
      .then((response) => response.json())
      .then((json) => {
        Membres.value = json;
      });
});

</script>


<template>
  <div id="pageMembre">
    <main id="app5">
      <h1>Gestion des membres en Vue</h1>
      <p>Sélectionnez un membre dans la liste :</p>
      <select v-model="leMembre" style="width:250px">
        <option v-for="membre in membres" :value="lieu">
          {{ membre.nom }}
        </option>
      </select>
      <div v-show="selectionne">
        <p><br/>Editez ses propriétés :</p>
        <table>
          <tr>
            <td>Nom : </td>
            <td><input v-model="leMembre.nom"/></td></tr>
          <tr><td>Prénom : </td><td><input v-model="leMembre.prenom"/></td></tr>
          <tr><td>Adresse : </td><td><input v-model="leMembre.adressse"/></td></tr>
          <tr><td>Date de naissance : </td><td><input v-model="leMembre.date_naissance"/></td></tr>
          <tr><td>Email : </td><td><input v-model="leMembre.email"/></td></tr>

        </table>
      </div>
      <br />
      <br />
      <h2>Ajouter un nouveau membre :</h2>
      <form action="membres?operation=ajouterMembre" method="post">

        <label for="nom">Nom du membre :</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="prenom">Prénom du membre :</label>
        <input type="text" id="prenom" name="Prénom" required><br>

        <label for="adresse">Adresse :</label>
        <input type="text" id="adresse" name="adresse" required><br>

        <label for="date_naissance">Date de naissance du membre :</label>
        <input type="date" id="date_naissance" name="date_naissance" required><br>

        <label for="email">Email :</label>
        <input type="text" id="email" name="email" required>email@domaine.fr<br>

        <label for="mdp">Mot de passe :</label>
        <input type="password" id="mdp" name="mdp" required>****<br>

        <button type="submit">Ajouter</button>
      </form>
      <br />
      <br />
      <h2>Supprimer un membre</h2>

      <form action="membres?operation=supprimerMembre" method="post">
        <label for="id">Id:</label>
        <input type="text" id="id" name="id" required><br>
        <br />
        <button type="submit">Supprimer</button>
      </form>
    </main>
  </div>
</template>

<style>
@import '../views/style.css';
</style>
