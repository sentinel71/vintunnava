<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Activate</title>
</head>
<body>
<!-- 	Your account is activated, click below to go to home page. -->
<%-- 	<a href="${pageContext.request.contextPath}/search">Click here</a> --%>
	${msg}
<%-- 	<c:if test="${not fn:containsIgnoreCase(msg, 'already')}"> --%>
        Click below to go to home page.
	 	<a href="${pageContext.request.contextPath}/search">Click here</a>
<%--     </c:if> --%>
</body>
</html>