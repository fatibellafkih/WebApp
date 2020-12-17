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

		<form class="needs-validation" novalidate action="/addAutomate"
			method="get">
			<label>Type</label><input class="form-control" type="text"
				name="type"> <label>Voie</label><input class="form-control"
				type="text" name="voie"> <label>Code Postal</label> <input
				class="form-control" type="text" name="code_postal"> <label>Ville</label>
			<input class="form-control" type="text" name="ville"> <label>Pays</label><input
				class="form-control" type="text" name="pays"> <label>Batiment</label><input
				class="form-control" type="number" name="batiment"> <label>Etage</label>
			<input class="form-control" type="number" name="etage"> <label>Escalier</label>
			<input class="form-control" type="number" name="escalier"> <label>Longitude</label>
			<input class="form-control" type="number" name="longitude"> <label>Latitude</label>
			<input class="form-control" type="number" name="latitude"> <label>Commentaire</label>
			<input class="form-control" type="text" name="note"> <input
				class="btn btn-primary" type="submit" value="Add">
		</form>
		<c:if test="${added == 1}">
			<label>Vous avez ajouté une automate</label>
		</c:if>

		<label>Trouver toutes les automates <a href="/printAutomates">ici</a></label>
	</div>
</body>
</html>