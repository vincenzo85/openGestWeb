<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@page import="com.opengest.core.business.vo.User"%>
<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<%String path = request.getContextPath();%>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/users.css"/>
		
	</head>
		<jsp:useBean id="userList" class="java.util.Vector" scope="request"></jsp:useBean>
	
	<body class="body-content">
		<div id="wrapper">
			
			<jsp:include page="../tiles/header.jsp"></jsp:include>
			
			<jsp:include page="../menu/menuTab.jsp"></jsp:include>
			
			
			<div id="main-container">
				<div>
					<div>
						<jsp:include page="../menu/userMenu.jsp"></jsp:include>
					</div>
					
					<div class="user-table-container">
							<table class="user-table">
								<thead> 
									<tr  class="user-table-header" >
										<th><fmt:message key="label.anagrafica.username.text"/></th>
										<th><fmt:message key="label.anagraficaNome.text"/></th>
										<th><fmt:message key="label.anagraficaCognome.text"/></th>
										<th><fmt:message key="label.anagrafica.email.text"/></th>
									</tr>
								</thead>
								<tbody>
									<%
										Iterator iterator = userList.iterator();
										while(iterator.hasNext()){
											User current = (User)iterator.next();
									%>
										<tr>
											<td>
												<form action="updateinit" method="post">
													<a href="updateinit?userId=<%=current.getId()%>">
														<%=current.getUsername()%>
													</a>
												</form>
											</td>
											<td><%=current.getNome()%></td>
											<td><%=current.getCognome()%></td>
											<td><%=current.getEmail()%></td>
											<td>
												<form action="delete" method="post" onsubmit="return confirmDelete()">
													<input class="image" type="image" src="<%=path%>/resources/images/delete.png" />
													<input type="hidden" name="userid" value="<%=current.getId()%>">
												</form>
											</td>
										</tr>	
									<%
										}
									%>	
					
					
								</tbody>
							</table>
					</div>
				</div>
			</div>
			
			<jsp:include page="../tiles/footer.jsp"></jsp:include>
			
		</div>
	</body>
</html>