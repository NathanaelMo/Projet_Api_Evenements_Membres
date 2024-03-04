<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un lieu</title>
</head>
<body>

    <h2>Ajouter un lieu</h2>

    <form action="lieux?operation=ajouterLieu" method="post">
        <label for="nom">Nom du lieu:</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="adresse">Adresse:</label>
        <input type="text" id="adresse" name="adresse" required><br>

        <label for="nbMaxPers">Nombre maximal de personnes:</label>
        <input type="number" id="nbMaxPers" name="nbMaxPers" required><br>

        <button type="submit">Ajouter</button>
    </form>

</body>
</html>