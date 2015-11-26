<%@ include file="include.jsp"%>
<c:if test="${user!=null}">
		<a href="${pageContext.request.contextPath}">Home</a> |
<c:if test="${FEATURE_VIEW_REPORTS!=null}">
		<a href="#" onclick="viewReports()">View Reports</a> |
</c:if>

	<c:if test="${FEATURE_INSERT_USER!=null}">
		<a href="#" onclick="createUser()">Create User</a> |
	</c:if>

	<c:if test="${FEATURE_EDIT_PROFILE!=null}">
		<a href="#" onclick="updateProfile()">Edit Profile</a> |
	</c:if>

	<a href="${pageContext.request.contextPath}/logout">Logout</a>
	<hr />
</c:if>