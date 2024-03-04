<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css.css" type="text/css">
    <title>Liste des lieux</title>
</head>
<body>

    <h3>Liste des membres</h3>
    <c:forEach items="${requestScope.membres}" var="membre">
        <h4>${membre.nom}${membre.prenom}</h4>
        <p>
            <b>Adresse : </b>${membre.adresse} &ndash; Date de naissance : ${membre.date_naissance} - Email : $${membre.email}
        </p>
    </c:forEach>

</body>
</html>
