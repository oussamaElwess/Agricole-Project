<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un compte</title>

</head>

<body>


<hr/>

	<h1>Ajoute d'un client : </h1>

		<form action="/Agricole/AjoutCompte" method="POST">
		
			<label for="id_user"><strong>Selectionnez un de vos clients : </strong></label>
			<select name="id_user">
				<c:forEach items="${clients}" var="client">
      		  	<option>${client.getPerson_external_id()} - ${client.getPerson_firstname()} ${client.getPerson_lastname()}
      			</c:forEach>
			</select><br><br>
			
			<label for="balance"><strong>Montant initial : </strong></label> <input type="text" name="balance"><br><br>
			
			<label for="type"><strong>Type de compte : </strong></label>
			<select name="type">
				<option>SAVINGS
				<option selected>CHECKING
				<option>LIFE_INSURRANCE
			</select><br><br>
			
			<input id="valide" type="submit" value="Valider">
		</form>

</body>

</html>