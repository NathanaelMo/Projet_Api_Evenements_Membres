<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
</head>
<body>

<h2>Inscription à un événement</h2>

<form action="../evenements?operation=inscriptionEvenement" method="post">
    <!-- TODO rajouter une liste qui permet sélectionner un membre-->
    <!-- TODO rajouter une liste qui permet sélectionner un événement -->
    <button type="submit">Ajouter</button>
</form>

</body>
</html>
