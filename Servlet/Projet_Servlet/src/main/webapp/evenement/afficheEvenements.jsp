<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css.css" type="text/css">
    <title>Liste des événements</title>
</head>
<body>

    <h3>Liste des événements</h3>
    <c:forEach items="${requestScope.evenements}" var="evenement">
        <h4>${evenement.nom} le ${evenement.duree}</h4>
        <p>
            <b>Durée : ${evenement.duree} - Nombre de participants : ${evenement.nb_participant}
        </p>
    </c:forEach>

</body>
</html>
