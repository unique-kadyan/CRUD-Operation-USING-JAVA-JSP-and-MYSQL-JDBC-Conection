<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.db.User.User"  %>
<c:import url="include/header.jsp"><c:param name="title" value="Home Page"/></c:import>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-4">
			<h1>Data Display Will be Done here only</h1>
	<table border="2">
			
				<thead>
					<th>User ID</th>
					<th>Username</th>
					<th>Email</th>
					<th>Operation</th>
				</thead>
				<c:forEach items="${list}" var="user">
				<tr>
 				<td>${user.idusers}</td>
 				<td>${user.name}</td>
 				<td>${user.email}</td>
 				<td>${user.mob}</td>
				<c:url var="updateURL" value="home">
				<c:param name="page" value="update"></c:param>			
				<c:param name="name" value="${user.name}"></c:param>
				<c:param name="email" value="${user.email}"></c:param>
				<c:param name="mobile" value="${user.mob}"></c:param>
				<c:param name="userid" value="${user.idusers}"></c:param>
				</c:url>
			
				<c:url var="deleteURL" value="home">
				<c:param name="page" value="delete"></c:param>			
				<c:param name="userid" value="${user.idusers}"></c:param>
				</c:url>			
 				
 				<td>
 				<a href="${updateURL}">Update</a>|
 				<a href="${deleteURL}"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
 				</td>
 				</tr>			
				</c:forEach>
			</table>
		</div>
	</div>
</div>

<%@include file="include/footer.jsp"%>




<!-- 
			
		<strong>	
			<%
			List<User> list = (List)request.getAttribute("list");
			if(list.size() == 0)
			{
				out.print("Sorry I have not having enough treasure to show. Please add it to my storage");
				return;
			}
			if(list.size() != 0){
				%></strong>
				<strong><thead>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th><th>Mobile</th><th>Operations Allowed</th>
			
			</thead></strong>
			<%
			for(int i=0; i < list.size(); i++)
			{
				String nam = list.get(i).getName().replaceAll(" ", "");
				String url = request.getContextPath()+"/home?page=update"+"&name="+nam+"&email="
						+list.get(i).getEmail()+"&mobile="+list.get(i).getMob()+"&userid="+list.get(i).getIdusers();
				String delurl = request.getContextPath()+"/home?page=delete"+"&userid="+list.get(i).getIdusers();
				out.print("<tr>");
				out.print("<td>"+list.get(i).getIdusers());
				out.print("<td>"+list.get(i).getName());
				out.print("<td>"+list.get(i).getEmail());
				out.print("<td>"+list.get(i).getMob());
				out.print("<td>		<a href="+url+">Update Records</a></td>");
				out.print("<td>		<a href="+delurl+" onclick=if(!confirm('Are you sure to delete the user?')) return false >Delete Records</a></td>");
			
				out.print("</tr>");
				
			}
			}
			%>
			</table> 
		</div>
	</div>
</div>
<c:import url="include/footer.jsp"></c:import> -->