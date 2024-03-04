<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un membre</title>
</head>
<body>

<h2>Ajouter un membre</h2>

<form action="../evenements?operation=ajouterEvenements" method="post">
    <label for="nom">Nom de l'évenement :</label>
    <input type="text" id="nom" name="nom" required><br>

    <label for="date">Date de l'évenement :</label>
    <input type="date" id="date" name="date" required><br>

    <label for="duree">Durée en jours :</label>
    <input type="number" id="duree" name="duree" min="1" required>1<br>

    <label for="nb_participant">Nombre de participant maximum :</label>
    <input type="number" id="nb_participant" name="nb_participant" min="1" required>1<br>


    <!-- TODO rajouter une liste qui permet sélectionner le lieu de l'évenement -->
    <button type="submit">Ajouter</button>
</form>

</body>
</html>
