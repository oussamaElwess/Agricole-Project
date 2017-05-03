<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contestation</title>
</head>
<body>

	
<h1>Messages </h1>
<table border="1">
<tr>
<th>Id Message</th>
<th>Contenu de message</th>
<th>message from </th>
<th>message to</th>
<th>Date</th>

</tr>
<c:forEach items="${msgs}" var="msg">
<tr>
	 <td>
	 ${msg.getMsg_id()}
	 </td>
	 <td>
	 ${msg.getMsg_content()}
	 </td>
	 <td>
	 ${msg.getMsg_from()}
	 </td>
	 <td>
	 ${msg.getMsg_to()}
	 </td>
	 <td>
	 ${msg.getMsg_created()}
	 </td>
 </tr>
</c:forEach>
</table>




<h1> Envoyer un message : </h1>
	<form method="get" action="/Agricole/Send">
		Id du message auquel vous répondez : <input type="text" name="IdOperation"/>
		Message <input type="text" name="msg"/>
	 	<input type="submit" value="Contester"/>
	</form>
</body>
</html>