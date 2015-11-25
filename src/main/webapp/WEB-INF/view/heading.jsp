<%@ include file="include.jsp"%> 
<c:if test="${userName!=null}">
<a href="#" onclick="viewReports()">View Reports</a> |
<a href="#" onclick="createUser()">Create User</a> |
<a href="#" onclick="updateProfile()">Edit Profile</a> | <a href="${pageContext.request.contextPath}/logout">Logout</a>
<hr/></c:if>