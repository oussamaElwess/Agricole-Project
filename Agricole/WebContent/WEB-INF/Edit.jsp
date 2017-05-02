<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="user" scope="session" class="com.ib.beans.User"></jsp:useBean>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editer ses informations</title>
</head>
<body>

<h1>Editer ses informations</h1>

<h2>Client n° : <jsp:getProperty property="person_external_id" name="user"/></h2>


<div id="form">
		<form action="/Agricole/Edit" method="POST">
			
			<div>Nom actuel : <jsp:getProperty property="person_lastname" name="user"/></div>
			<label for="nom_user"><strong>Nouveau nom : </strong></label> <input type="text" name="nom_user"><br><br>
			
			<div>Prénom actuel : <jsp:getProperty property="person_firstname" name="user"/></div>
			<label for="nom_user"><strong>Nouveau prénom : </strong></label> <input type="text" name="prenom_user"><br><br>
			
			<div>Email actuel : <jsp:getProperty property="person_email" name="user"/></div>
			<label for="nom_user"><strong>Nouvel email : </strong></label> <input type="text" name="email_user"><br><br>
			
			
			<label for="nom_user"><strong>Nouveau mot de passe : </strong></label> <input type="text" name="mdp_user"><br><br>
				
			
			<input id="valide" type="submit" value="Valider">
		</form>
	</div>

</body>
</html>