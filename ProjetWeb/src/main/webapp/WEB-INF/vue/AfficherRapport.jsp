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
	       
		<!-- /* This part is for the "hors service" */ -->
	    <div class="container">
	    	<h2>Liste des automates hors-service</h2>
	      	<table class="table table-striped">
		      	<thead class="thead-dark">	
			      	<tr>
			      		<th scope="col"> Id rapport </th>
			      		<th scope="col"> Hors Service </th>
			      	</tr>
		      	</thead>
		        <c:set var="count" value="0" scope="page" />
		      	<tbody>
			        <c:forEach  items="${reports}" var ="report">
			        	<tr>
				        	<c:if test="${report.etat == 'hors service'}">
				        		<td scope="row">${report.id}</td>
				        		<td scope="row">${report.numeroSerie}</td>
				        		<c:set var="count" value="${count + 1}" scope="page"/>
				        	</c:if>      	     	
			        	</tr>
			        </c:forEach>
			       	<c:if test="${count == 0}">  
						<td scope="row">Aucun problème</td>  
					</c:if> 
					<c:remove var="count" scope="page" />
				</tbody>
	      	</table>
	    
		<!-- /* This part is for the "A surveiller" */ -->  
			<h2>Liste des automates qui posent problèmes</h2> 
	      	<table class="table table-striped">
		      	<thead class="thead-dark">
			      	<tr>
			      		<th scope="col"> Id rapport </th>
			      		<th scope="col"> A surveiller </th>
			      		<th scope="col"> Raison</th>
			      	</tr>
		      	</thead>
		        <c:set var="count" value="0" scope="page" />
		      	<tbody>
			        <c:forEach  items="${reports}" var ="report">
			        	<tr>
				        	<c:if test="${report.etat == 'en service' && report.infosAutomate.etat != 'ok'}">
				        		<td scope="row">${report.id}</td>
			        			<td scope="row">${report.numeroSerie}</td>
				        		<td scope="row">${report.infoAutomate.etat}</td>
				        	</c:if>      	     	
			        	</tr>
			        </c:forEach>
			  	</tbody>
	      	</table>
	    
	   	<!-- /* This part is for the "Reaprovisionnement part" */ -->
	   		<h2>Liste des articles par automates qui manquent</h2>   
			<table class="table table-striped">	
				<thead class="thead-dark">	
			      	<tr>
			      		<th scope="col"> Id rapport</th>
			      		<th scope="col"> Automate</th>
			      		<th colspan="6" scope="colgroup"> A réaprovisionner </th>
			      	</tr>
			    </thead>
			    <tbody>
			        <c:forEach  items="${reports}" var ="report">
			      		<tr>
			      			<td scope="row">${report.id}</td>
					        <td scope="row">${report.numeroSerie}</td>
							<c:set var="count" value="0" scope="page" />
							
				        	<c:forEach  items="${report.articles}" var ="article">
								<c:if test="{meteo.length() == 0}">
									<c:set var="weather" value="10" scope="page"/>
								</c:if>
								<c:if test="{meteo.length() != 0}">
									<c:set var="weather" value="${meteo[report.numeroSerie-1]}" scope="page"/>
								</c:if>
				        			<c:if test="${article.type == 'chaud' && weather <= 5 && article.quantite <= 30}"> 
						        			<c:set var="count" value="${count + 1}" scope="page"/>
									   		<td scope="row">${article.nom}</td>  							        			
				        			</c:if>
				        			<c:if test="${article.type == 'chaud' && weather > 5 && article.quantite <= 10}">
						        			<c:set var="count" value="${count + 1}" scope="page"/>
									   		<td scope="row">${article.nom}</td>  								        			
				        			</c:if>
				        			<c:if test="${article.type == 'froid' && weather < 25 && article.quantite <= 10}"> 
						        			<c:set var="count" value="${count + 1}" scope="page"/>
									   		<td scope="row">${article.nom}</td>  								        			
				        			</c:if>
				        			<c:if test="${article.type == 'froid' && weather >= 25 && article.quantite <= 30}">
						        			<c:set var="count" value="${count + 1}" scope="page"/>
									   		<td scope="row">${article.nom}</td>  								        			
				        			</c:if>
				        			<c:if test="${article.type == 'Nourriture' && article.quantite <= 10}"> 
						        			<c:set var="count" value="${count + 1}" scope="page"/>
									   		<td scope="row">${article.nom}</td>  
				        			</c:if>	        					        			
						    </c:forEach>
							<c:if test="${count == 0}">  
								<td scope="row">Nothing to refill</td>  
							</c:if> 					
							<c:remove var="count" scope="page" />
							<c:remove var="weather" scope="page" />
						</tr>
			        </c:forEach>
			    </tbody>
	        </table>
	    
	    <!-- /* This part is for the "Ventes" part */ -->  
	    	<h2>Liste des revenus de chaques automate par rapport</h2>  
			<table class="table table-striped">	
				<thead class="thead-dark">		
			      	<tr>
			      		<th scope="col"> Id rapport </th>
			      		<th scope="col"> Automate </th>
			      		<th scope="col"> Revenu</th>
			      	</tr>
			     </thead>
			     <tbody>
			        <c:forEach  items="${reports}" var ="report">
			      		<tr>
			      			<td scope="row">${report.id}</td>
					        <td scope="row">${report.numeroSerie}</td>
							<td scope="row">${report.benefice}</td>  
						</tr>
			        </c:forEach>
			    </tbody>
	        </table>
		<p>Trouver toutes les automates  <a href="/printAutomates">ici</a></p>
		</div>
	</body>
</html>
