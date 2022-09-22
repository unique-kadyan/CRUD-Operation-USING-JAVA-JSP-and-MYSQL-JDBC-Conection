<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.db.User.User"%>
<c:import url="include/header.jsp">
	<c:param name="title" value="Adding data Page" />
</c:import>
<div class="container mtb" style="text-align: center">
	<div class="row">
		<div class="col-lg-6">
			<form action="${pageContext.request.contextPath}/home" method="post">
				Full Name: <input type="text" name="fname" value="fullname" required><br>
				Mobile: <input type="number" name="mob" value="mobile" required><br>
				Email: <input type="email" name="email" value="email" required><br>
				<form action="${pageContext.request.contextPath}/home" method="post"
					enctype="multipart/form-data">
					Select images <input type="file" name="files" multiple /> <input
						type="submit" value="upload" /> <input type="hidden"
						value="addinguser" name="form"> <input type="submit"
						value="added">

				</form>
		</div>
	</div>
</div>

<c:import url="include/footer.jsp"></c:import>