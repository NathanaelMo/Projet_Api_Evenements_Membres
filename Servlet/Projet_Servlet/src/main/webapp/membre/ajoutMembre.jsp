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

<form action="../membres?operation=ajouterMembres" method="post">
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

</body>
</html>
