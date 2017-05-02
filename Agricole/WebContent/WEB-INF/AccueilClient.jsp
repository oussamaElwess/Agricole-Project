<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     <jsp:useBean id="user" scope="session" class="com.ib.beans.User"></jsp:useBean>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Client</title>
</head>
<body>



<h1>Bonjour ${user.getPerson_firstname()}</h1>


<hr/>

	<h2>Mes comptes :</h2>
	
	
	<table border="1">
	<tr>
	<th>Id compte</th>
	<th>Solde</th>
	<th>Type de compte</th>
</tr>
<c:forEach items="${comptes}" var="compte">

<tr>
     <td>
     ${compte.getAccount_id()}
     </td>
     <td>
     ${compte.getAccount_balance()}
     </td>
     <td>
     ${compte.getAccount_type()}
     </td>
     
    </tr>
</c:forEach>
</table>
	
	
<hr/>

<p>
<a href="/Agricole/Edit"><input type="button" value="Editer mes informations"></a>

<a href="/Agricole/TraitOp"><input type="button" value="Voir opérations"></a>

</p> 

<p><a href="/Agricole/LogOut"><input type="button" value="Deconnexion"></a></p> 

</body>
</html>