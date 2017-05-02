<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>

</head>
<body>
	<div id="corp">
	<div id="entete">
		<img class="identification">
		<h2 class="identification">La Societé Agricole Coopérative</h2>
		
	</div>
	<div>
		<form action="/Agricole/Connect" method="get">
			<label for="nom_user"><strong>Identifiant : </strong></label> <input type="text" name="nom_user"><br><br>
			<label for="pass_user"><strong>Password : </strong></label> <input type="password" name="pass_user"><br>
			<%String msg=(String)request.getAttribute("msg");
				if(msg==null){
					msg="";
				}
				%>
			<span id="msg"><%=msg%></span><br>
			<input id="valide" type="submit" value="Valider">
		</form>
	</div>
	</div>
</body>
</html>