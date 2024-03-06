<script setup>
import {ref, onMounted, computed, reactive} from 'vue';

const auteur = ref('Charlotte');
const membres = ref([]);
const idMembreInput = ref(null);
const EvenementsParMembre= ref([]);

const state = reactive({
  leMembreId: null,
  membre: {},
  leMembre: {},
});

const nbMembres = computed(() => {
  return Membres.value.length;
});

onMounted(() => {
  fetch('http://localhost:8080/Spring/membres')
      .then((response) => response.json())
      .then((json) => {
        membres.value = json;
        console.log(membres.value);
      });
});

const getEvenementsParMembre = () => {
  const id_membre = idMembreInput.value.value;
  fetch(`http://localhost:8080/Spring/membres/${id_membre}/evenements`)
      .then((response) => response.json())
      .then((json) => {EvenementsParMembre.value = json});
}

</script>


<template>
  <div id="pageMembre">
    <main id="app5">
      <h1>Gestion des membres en Vue</h1>
      <p>Sélectionnez un membre dans la liste :</p>
      <select ref="leMembre" v-model="state.leMembre" style="width:250px">
        <option v-for="membre in membres" :value="membre">
          {{ membre.nom }} {{ membre.prenom }}
        </option>
      </select>
      <div>
        <p><br/>Editez ses propriétés :</p>
        <table>
          <tr>
            <td>Nom : </td>
            <td><input v-model="state.leMembre.nom"/></td></tr>
          <tr><td>Prénom : </td><td><input v-model="state.leMembre.prenom"/></td></tr>
          <tr><td>Adresse : </td><td><input v-model="state.leMembre.adresse"/></td></tr>
          <tr><td>Date de naissance : </td><td><input v-model="state.leMembre.date_naissance"/></td></tr>
          <tr><td>Email : </td><td><input v-model="state.leMembre.email"/></td></tr>

        </table>
      </div>
      <br />
      <br />
      <h2>Ajouter un nouveau membre :</h2>
      <form action="http://localhost:8080/Spring/membres" method="post">

        <label for="nom">Nom du membre :</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="prenom">Prénom du membre :</label>
        <input type="text" id="prenom" name="Prénom" required><br>

        <label for="adresse">Adresse :</label>
        <input type="text" id="adresse" name="adresse" required><br>

        <label for="date_naissance">Date de naissance du membre :</label>
        <input type="date" id="date_naissance" name="date_naissance" required><br>

        <label for="email">Email :</label>
        <input type="text" id="email" name="email" required><br>

        <label for="mdp">Mot de passe :</label>
        <input type="password" id="mdp" name="mdp" required><br>

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


      <h2>Afficher les événement du membre d'id:</h2>
      <form>
        <label for="choix_membre">Choisir un membre :</label>
        <select id="choix_membre" ref="membre" v-model="state.membre" style="width:100px">
          <option v-for="membre in membres" :value="membre">
            {{ membre.nom }}
          </option>
        </select>
        <br />
        <label for="id_membre">Id du membre:</label>
        <input ref="idMembreInput" type="text" id="id_membre" name="id_membre" required v-model="state.membre.idMembre"><br>
        <br />
        <button @click.prevent="getEvenementsParMembre">Chercher</button><br />
      </form>
      <div v-for="evenement in EvenementsParMembre" :key="evenement">
        <p>Evenement : {{ evenement.nom }}  </p>
      </div>


    </main>
  </div>
</template>

<style>
@import '../views/style.css';
</style>
