<script setup>
import { ref, onMounted, reactive } from 'vue';
import axios from "axios";

const auteur = ref('Charlotte');
const Evenements = ref([]);
const lieux = ref([]);
const nbEvenements = ref(0);
const membreParEvenement = ref([]);
const leLieu = ref(null);
const evenement = ref(null);
const state = reactive({
  evenementId: null,
  evenement: {},
  leLieu: {}
});

onMounted(() => {
  fetch('http://localhost:8080/Spring/evenements')
      .then((response) => response.json())
      .then((json) => {
        Evenements.value = json;
        nbEvenements.value = json.length;
      });
  fetch('http://localhost:8080/Projet_Servlet/lieux?operation=listeLieux')
      .then((response) => response.json())
      .then((json) => {
        lieux.value = json;
      });
});

const getMembreParEvenement = () => {
  const idEvenement = state.evenement.idEvenement;
  console.log(idEvenement);
  fetch(`http://localhost:8080/Spring/evenements/${idEvenement}/membres`)
      .then((response) => response.json())
      .then((json) => {
        membreParEvenement.value = json;
      });

};
const submitModifierEvenement = () => {
  const formData = {
    id_evenement: state.evenement.idEvenement,
    date: state.evenement.date,
    duree: state.evenement.duree,
    nb_max_pers: state.evenement.nbMaxPers,
    // Ajoutez d'autres propriétés si nécessaire
  };
  fetch('http://localhost:8080/Spring/evenements', {
    method: 'PUT',
    headers: {
      'Origin': 'http://localhost:5173/', // Spécifiez l'origine autorisée
      'Content-Type': 'application/json' // Spécifiez le type de contenu de la requête
    },
    body: JSON.stringify({formData}) // Convertissez les données en JSON si nécessaire
  }).then(response => {
    console.log(response.data);
  })
  .catch(error => {
      console.error('Erreur lors de la requête POST :', error);
  })
}

</script>

<template>
  <!-- /////////////////////////////////////////////Evenement///////////////////////////////////////////////////////////// -->
  <div id="pageEvenement">

    <h2>Liste des {{ nbEvenements }} événements :</h2>
    <select ref="evenement" v-model="state.evenement" style="width:250px">
      <option v-for="Evenement in Evenements" :value="Evenement">
        {{ Evenement.nom }}
      </option>
    </select>
    <br />
    <br />

    <h2>Modifier un événement :</h2>
    <form id="modifEvenement" @submit.prevent="submitModifierEvenement" action="http://localhost:8080/Spring/evenements" method="post">
      <label for="id_evenement">Id de l'evenement :</label>
      <input type="text" id="id_evenement" name="id_evenement" required v-model="state.evenement.idEvenement"><br>
      <br />
      <label for="date">Date :</label>
      <input type="date" id="date" name="date" min="1" required v-model="state.evenement.date"><br>
      <br />
      <label for="duree">Duree :</label>
      <input type="number" id="duree" name="duree" min="1" required v-model="state.evenement.duree"><br>
      <br />
      <label for="nb_max_pers">Nombre de personnes maximum :</label>
      <input type="number" id="nb_max_pers" name="nb_max_pers" required v-model="state.evenement.nbMaxPers"><br>
      <br />
      <input type="hidden" name="Content-Type" value="application/json">

      <button type="submit">Modifier</button>
    </form>

      </div>
      <br />
      <br />
      <h2>Ajouter un nouveau Evenement :</h2>
      <form action="http://localhost:8080/Spring/evenements" method="post">
        <label for="nom">Nom de l'événement :</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="date">Date de l'événement :</label>
        <input type="date" id="date" name="date" required><br>

        <label for="duree">Durée en jours :</label>
        <input type="number" id="duree" name="duree" min="1" required><br>

        <label for="nb_participant">Nombre de participant maximum :</label>
        <input type="number" id="nb_participant" name="nb_participant" min="1" required><br>
        <br />
        <label for="choix_lieu">Choisissez un lieu :</label>
        <select id="choix_lieu" ref="leLieu" v-model="state.leLieu" style="width:100px">
          <option v-for="lieu in lieux" :value="lieu">
            {{ lieu.nom }}
          </option>
        </select>
        <br />
        <label for="id_lieu">Id du Lieu :</label>
        <input type="number" id="id_lieu" name="nouveau_message" required v-model="state.leLieu.idLieu"><br>
        <br />

        <button type="submit">Ajouter</button>
      </form>
      <br />
      <br />
      <h2>Supprimer un Evenement</h2>
      <form action="Evenements?operation=supprimerEvenement" method="post">
        <label for="choix_event">Choisissez un événement :</label>
        <select id="choix_event" ref="evenement" v-model="state.evenement" style="width:100px">
          <option v-for="evenement in Evenements" :value="evenement">
            {{ evenement.nom }}
          </option>
        </select>
        <br />
        <label for="id_evenement">Id de l'événement:</label>
        <input ref="idEvenementInput" type="text" id="id_evenement" name="id_evenement" required v-model="state.evenement.idEvenement"><br>
        <br />
        <button type="submit">Supprimer</button>
      </form>

      <h2>Afficher les membres de l'événement d'id:</h2>
      <form>
        <label for="choix_event">Choisissez un événement :</label>
        <select id="choix_event" ref="evenement" v-model="state.evenement" style="width:100px">
          <option v-for="evenement in Evenements" :value="evenement">
            {{ evenement.nom }}
          </option>
        </select>
        <br />
        <label for="id_evenement">Id de l'événement:</label>
        <input ref="idEvenementInput" type="text" id="id_evenement" name="id_evenement" required v-model="state.evenement.idEvenement"><br>
        <br />
        <button @click.prevent="getMembreParEvenement">Chercher</button><br />
      </form>
      <div v-for="membre in membreParEvenement" :key="membre.idMembre">
        <p>Membre : {{ membre.nom }} {{membre.prenom}} </p>
      </div>
</template>

<style>
@import '../views/style.css';
</style>
