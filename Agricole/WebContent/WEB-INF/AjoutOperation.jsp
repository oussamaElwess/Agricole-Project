<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un op�ration</title>
</head>
<body>

<h1>Ajouter une op�ration : </h1>

		<form action="/Agricole/AjoutOperation" method="POST">
		
			<label for="opType"><strong>Type d'op�ration : </strong></label> <input type="text" name="opType"><br><br>
			
			<label for="opMontant"><strong>Montant de l'op�ration : </strong></label> <input type="text" name="opMontant"><br><br>

			<label for="opDescription"><strong>Description : </strong></label> <input type="text" name="opDescription"><br><br>
			
			<input id="valide" type="submit" value="Valider">
		</form>

</body>
</html>