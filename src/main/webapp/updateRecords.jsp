<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="include/header.jsp"><c:param name="title" value="Error page"/></c:import>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<form action="${pageContext.request.contextPath}/home" method="post">
				Full Name: <input type="text" name="fname" value="${param.name}" required><br>
				Mobile: <input type="number" name="mob" value="${param.mobile }" required><br>
				Email: <input type="email" name="email" value="${param.email }" required><br>
				<input type="hidden" value="${param.userid}"  name="userid">
				<input type="hidden" value="update" name="form">				
				<input type="submit" value="Updated">
				
			</form>
		</div>
	</div>
</div>
<c:import url="include/footer.jsp"></c:import>