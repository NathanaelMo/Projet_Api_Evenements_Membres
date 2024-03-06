<script setup>
import {ref, onMounted, computed, reactive} from 'vue';

  const auteur = ref('Charlotte');
  const commentaires = ref([]);
  const commentairesParEvenement = ref([]);
  const idEvenementInput = ref(null);
  const state = reactive({
    leCommentaireId: null,
    leCommentaire: {},
  });
  const nbCommentaires = computed(() => {
    return commentaires.value.length;
  });

  onMounted(() => {
    fetch('http://localhost:8080/Projet_Servlet/commentaires?operation=listeCommentaires')
        .then((response) => response.json())
        .then((json) => {
          commentaires.value = json;
        });
  });

  const getCommentairesParEvenement = () => {
    const idEvenement = idEvenementInput.value.value;
    console.log(idEvenement)
    fetch(`http://localhost:8080/Projet_Servlet/commentaires?operation=CommentairesParEvenement&id_evenement=${idEvenement}`)
        .then((response) => response.json())
        .then((json) => {
          commentairesParEvenement.value = json;
        });

  }
</script>


<template>
  <!-- /////////////////////////////////////////////COMMENTAIRE///////////////////////////////////////////////////////////// -->
  <div id="pageCommentaire">
    <h2>Liste des {{ nbCommentaires }} commentaires :</h2>
      <select ref="leCommentaire" v-model="state.leCommentaire" style="width:250px">
        <option v-for="com in commentaires" :value="com">
          {{ com.message }}
        </option>
      </select>
      <br />
      <br />
    <h2>Modifier un commentaire :</h2>
    <form id="modifCom" action="http://localhost:8080/Projet_Servlet/commentaires?operation=modifierCommentaire" method="post">
      <label for="id_message">Id du message:</label>
      <input type="text" id="id_message" name="id_message" required v-model="state.leCommentaire.id_message"><br>
      <br />
      <label for="nouveau_message">Nouveau message:</label>
      <input type="text" id="nouveau_message" name="nouveau_message" required v-model="state.leCommentaire.message"><br>
      <br />
      <button type="submit">Modifier</button>
    </form>
    <br />
    <br />
      <h2>Ajouter un nouveau commentaire :</h2>
      <form action="http://localhost:8080/Projet_Servlet/commentaires?operation=ajouterCommentaire" method="post">
        <label for="id_evenement">Id de l'évenement:</label>
        <input type="text" id="id_evenement" name="id_evenement" required><br>
        <br />
        <label for="id_message">Id du message:</label>
        <input type="text" id="id_message" name="id_message" required><br>
        <br />
        <label for="message">Commentaire:</label>
        <input type="text" id="message" name="message" required><br>
        <br />
        <button type="submit">Ajouter</button>
      </form>
      <br />
      <br />
      <h2>Supprimer un commentaire</h2>
      <form action="http://localhost:8080/Projet_Servlet/commentaires?operation=supprimerCommentaire" method="post">
        <label for="id_message">Id:</label>
        <input type="text" id="id_message" name="id_message" required><br>
        <br />
        <button type="submit">Supprimer</button>
      </form>
    <br />
    <br />
    <h2>Afficher les commentaires de l'événement d'id:</h2>
    <form>
      <label for="id_evenement">Id:</label>
      <input ref="idEvenementInput" type="text" id="id_evenement" name="id_evenement" required><br>
      <br />
      <button @click.prevent="getCommentairesParEvenement">Chercher</button><br />
    </form>
    <div v-for="commentaire in commentairesParEvenement" :key="commentaire.id_message">
      <p>message : {{ commentaire.message }}</p>
    </div>
  </div>
</template>

<style>
@import '../views/style.css';
</style>
