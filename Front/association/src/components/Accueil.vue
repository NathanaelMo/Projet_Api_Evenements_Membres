<template>
  <div class="home">
    <header>
      <h1>Bienvenue sur le Site de Notre Association</h1>
      <p>Ensemble pour un monde meilleur</p>
    </header>

    <section class="about-us">
      <h2>À propos de nous</h2>
      <p>
        Notre association a pour mission de [...]. Nous travaillons à [...].
        Rejoignez-nous dans notre quête pour [...].
      </p>
    </section>

    <section class="get-involved">
      <h2>Impliquez-vous</h2>
      <p>
        Vous pouvez vous impliquer en [...]. Que vous soyez intéressé par [...],
        il y a toujours une place pour vous dans notre association.
      </p>
      <button @click="joinUs">Rejoignez-nous</button>
    </section>
  </div>
</template>

<script>
export default {
  methods: {
    joinUs() {
      // Ajoutez ici la logique pour rediriger vers une page d'adhésion ou une autre action
      console.log('Redirigez vers la page d\'adhésion ou une autre action');
    }
  }
};
</script>

<style scoped>
/* Ajoutez vos styles CSS ici */
.home {
  max-width: 800px;
  margin: auto;
  padding: 20px;
  text-align: center;
}

header {
  margin-bottom: 30px;
}

button {
  background-color: #007BFF;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
p{
  color: black;
}
h2{
    color: black;
}
</style>
