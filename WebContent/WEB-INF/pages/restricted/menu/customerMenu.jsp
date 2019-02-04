<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	
		<head>
			<title>Open GEST</title>
		</head>
		<%String path = request.getContextPath();%>
		<div id="usermenu" class="left-float-component">
		  <ul id="menulink">
		        <li class="bordered-menu"><a href="<%=path%>/restricted/customers/list">Elenco Clienti</a></li>
		        <li class="bordered-menu"><a href="<%=path%>/restricted/customers/createinit">Nuovo Cliente</a></li>
		    </ul>
		</div>

</html>