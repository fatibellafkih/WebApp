<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>JSON</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	</head>
	<body>
	       
	    <!-- /* This part is for the "Ventes" part */ -->   
	   <div class="container">
	   		<h2>Tous les automates existant</h2>  
			<table class="table table-striped">	
				<thead class="thead-dark">	
			      	<tr>
			      		<th scope="col"> Automate </th>
			      		<th scope="col"> Type </th>
			      		<th scope="col"> Adresse d'installation </th>
			      		<th scope="col"> Emplacement </th>
			      		<th scope="col"> Coordonnées </th>
			      		<th scope="col"> Date d'intervention </th>
			      		<th scope="col"> Note</th>
			      	</tr>
		      	<thead>
		      	<tbody>
			        <c:forEach  items="${automates}" var ="automate">
			      		<tr>
					        <td scope="row">${automate.numeroSerie}</td>
							<td scope="row">${automate.type}</td>
							<td scope="row">${automate.adresseInstallation.voie} ${automate.adresseInstallation.codePostal} in
							  ${automate.adresseInstallation.ville}   in  ${automate.adresseInstallation.pays}</td>  
							<td scope="row">${automate.emplacement.batiment} ${automate.emplacement.etage} in
							  ${automate.emplacement.escalier}</td>  
							<td scope="row">(${automate.coordonnees.longitude}  ,  ${automate.coordonnees.latitude})</td>  
							<td scope="row">${automate.dateIntervention}</td>  
							<td scope="row">${automate.commentaire}</td>  
						</tr>
			        </c:forEach>
		        </tbody>
	        </table>
	    <p>Trouver tous les automates  <a href="/printAutomates">ici</a></p>
	    <p>Cliquer <a href="/addAutomate">ici</a> pour ajouter une automate </p>    
	    <p>cliquer <a href="/delete">ici</a> pour supprimer une automate </p>
	    </div>
	</body>
</html>