<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Supprimer un membre</title>
</head>
<body>

    <h2>Supprimer un membre</h2>

    <form action="membres?operation=supprimerMembre" method="post">
        <label for="id">Id:</label>
        <input type="text" id="id" name="id" required><br>

        <button type="submit">Supprimer</button>
    </form>

</body>
</html>
