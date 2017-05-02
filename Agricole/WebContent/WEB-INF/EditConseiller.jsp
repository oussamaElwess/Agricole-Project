<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="user" scope="session" class="com.ib.beans.User"></jsp:useBean>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editer des informations client</title>
</head>
<body>

<h1>Editer des informations client</h1>



<div id="form">
		<form action="/Agricole/EditConseiller" method="POST">
		
			<label for="client_id"><strong>Numéro du client à modifier : </strong></label> <input type="text" name="client_id"><br><br>
			
			<label for="nom_user"><strong>Nouveau nom : </strong></label> <input type="text" name="nom_user"><br><br>

			<label for="prenom_user"><strong>Nouveau prénom : </strong></label> <input type="text" name="prenom_user"><br><br>

			<label for="email_user"><strong>Nouvel email : </strong></label> <input type="text" name="email_user"><br><br>
			
			<label for="mdp_user"><strong>Nouveau mot de passe : </strong></label> <input type="text" name="mdp_user"><br><br>
				
			
			<input id="valide" type="submit" value="Valider">
		</form>
	</div>

</body>
</html>