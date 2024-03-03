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

    <h3>Liste des lieux</h3>
    <c:forEach items="${requestScope.lieux}" var="lieu">
        <h4>${lieu.nom}</h4>
        <p>
            <b>Adresse : </b>${lieu.adresse} &ndash; ${lieu.nbMaxPers} personnes maximum
        </p>
    </c:forEach>

</body>
</html>