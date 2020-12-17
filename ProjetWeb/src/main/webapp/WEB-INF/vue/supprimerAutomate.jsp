<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>JSON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<label>Entrer le numéro de série de l'automate à supprimer</label>
		<form class="needs-validation" novalidate action="/deleteAutomate"
			method="get">
			<label>Numéro de série</label> <input type="number" class="form-control"
				name="id" placeholder="xxx"> <input class="btn btn-primary"
				type="submit" value="Delete">
		</form>

		<c:if test="${deleted == 1}">
			<label>Vous avez supprimé une automate</label>
		</c:if>

		<label>Trouver toutes les automates<a href="/printAutomates">ici</a></label>
	</div>
</body>
</html>