<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     <jsp:useBean id="user" scope="session" class="com.ib.beans.User"></jsp:useBean>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Conseiller</title>
</head>
<body>

<h1>Interface conseillers</h1>

<br/>

<h2>Conseiller n°${user.getPerson_advisor_id()} - ${user.getPerson_firstname()} ${user.getPerson_lastname()}</h1>

<div>Nombre de contestation : ${ nb_op_contested }</div>


<hr/>

	<h3>Mes clients :</h2>
	
	
	<table border="1">
	<tr>
	<th>Id client</th>
	<th>Prénom</th>
	<th>Nom</th>
	<th>email</th>
	<th>Numéro de téléphone</th>
	<th>Client depuis</th>
	
</tr>
<c:forEach items="${clients}" var="user">

<tr>
     <td>
     ${user.getPerson_external_id()}
     </td>
     <td>
     ${user.getPerson_firstname()}
     </td>
     <td>
     ${user.getPerson_lastname()}
     </td>
     <td>
     ${user.getPerson_email()}
     </td>
     <td>
     ${user.getPerson_phone_number()}
     </td>
     <td>
     ${user.getPerson_created_At()}
     </td> 
    </tr>
</c:forEach>
</table>
	
	
<hr/>

<p>
<a href="/Agricole/AjoutClient"><input type="button" value="Ajouter un client"></a>

<a href="/Agricole/EditConseiller"><input type="button" value="Editer informations client"></a>

<a href="/Agricole/Contest"><input type="button" value="Voir contestations"></a>

<a href="/Agricole/AjoutCompte"><input type="button" value="Ajouter un compte"></a>

</p> 

<p><a href="/Agricole/LogOut"><input type="button" value="Deconnexion"></a></p> 

</body>
</html>