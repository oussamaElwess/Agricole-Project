<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un client</title>
</head>
<body>

<h1>Ajouter un client : </h1>

		<form action="/Agricole/AjoutClient" method="POST">
		
			<label for="id_user"><strong>Numéro du client à 8 chiffres : </strong></label> <input type="text" name="id_user"><br><br>
			
			<label for="nom_user"><strong>Nom : </strong></label> <input type="text" name="nom_user"><br><br>

			<label for="prenom_user"><strong>Prénom : </strong></label> <input type="text" name="prenom_user"><br><br>

			<label for="email_user"><strong>Email : </strong></label> <input type="text" name="email_user"><br><br>
			
			<label for="mdp_user"><strong>Mot de passe : </strong></label> <input type="text" name="mdp_user"><br><br>
			
			<label for="dob_user"><strong>Date de naissance : </strong></label> <input type="text" name="dob_user"><br><br>
			
			<label for="phone_user"><strong>Telephone : </strong></label> <input type="text" name="phone_user"><br><br>

				
			
			<input id="valide" type="submit" value="Valider">
		</form>
		
		
</body>
</html>