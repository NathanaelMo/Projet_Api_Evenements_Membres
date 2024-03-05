<script setup>
  const { ref, onMounted, computed } = require('vue');

  const auteur = ref('Charlotte');
  const commentaires = ref([]);

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
  const app3 = Vue.createApp(Commentaires).mount('#app3')
</script>

<template>
  <!-- /////////////////////////////////////////////COMMENTAIRE///////////////////////////////////////////////////////////// -->
  <div id="pageCommentaire" style="display:none;">
    <main id="app3">
      <p>Il y a {{ nbCommentaires }} commentaires dans la base.</p>
      <div v-for="commentaire in commentaires" :key="commentaire.id_message">
        <p>message : {{ commentaire.message }}</p>
        <p>Id evenement : {{ commentaire.id_evenement }}</p>
      </div>
      <br />
      <br />
      <h2>Ajouter un nouveau commentaire :</h2>
      <form action="commentaires?operation=ajouterCommentaire" method="post">
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
      <form action="commentaires?operation=supprimerCommentaire" method="post">
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
