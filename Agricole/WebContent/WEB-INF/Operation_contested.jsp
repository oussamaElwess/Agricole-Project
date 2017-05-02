<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operations</title>
</head>
<body>
<h1> Listes des operation contester</h1>
<table border="1">
<tr>
<th>Id Operation</th>
<th>type Operation</th>
<th>amount Operation</th>
<th>Description de l'Operation</th>
<th>Account ID</th>
<th>Creation de l'Operation</th>
<th>Mise à jour de l'Operation</th>
<th>Dispute Operation</th>
</tr>
<c:forEach items="${operations}" var="operation">

<tr>
	 <td>
	 ${operation.getOp_id()}
	 </td>
	 <td>
	 ${operation.getOp_type()}
	 </td>
	 <td>
	 ${operation.getOpe_amount()}
	 </td>
	 <td>
	 ${operation.getOpDescription()}
	 </td>
	 <td>
	 ${operation.getOpeAccountId()}
	 </td>
	 <td>
	 ${operation.getOpeCreated()}
	 </td>
	 <td>
	 ${operation.getOpeUpdated()}
	 </td>
	 <td>
	 ${operation.getOpe_dispute()}
	 </td>
 </tr>
</c:forEach>
 	<tr>
	<td>
	 <form method="get" action="#">
	 	<input type="submit" value="Retour"/>
	 
	 </form> 
	 </td>
	 </tr>
</table>
</body>
</html>