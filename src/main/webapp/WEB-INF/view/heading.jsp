<%@ include file="include.jsp"%>
<div>
<c:if test="${user!=null}">
		<a href="${pageContext.request.contextPath}">Home</a> |
<c:if test="${FEATURE_VIEW_REPORTS!=null}">
		<a href="#" onclick="viewReports()">View Reports</a> |
</c:if>
<a href="${pageContext.request.contextPath}/viewReports" target="_new">View Reports</a>

	<c:if test="${FEATURE_INSERT_USER!=null}">
		<a href="#" onclick="createUser()">Create User</a> |
	</c:if>

	<c:if test="${FEATURE_EDIT_PROFILE!=null}">
		<a href="#" onclick="updateProfile()">Edit Profile</a> |
	</c:if>

	<a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
	<hr /><div style="text-align:right;color:#ff0000">* Symbol on the form Indicates Mandatory input field</div>
	
</c:if>