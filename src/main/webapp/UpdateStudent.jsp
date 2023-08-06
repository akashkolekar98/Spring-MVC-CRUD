<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${updated}</h1>
	<form:form action="studentupdated" modelAttribute="student">
	ID:<form:input path="id" />
		<br>
    Name:<form:input path="name" />
		<br>
    Email:<form:input path="gmail" />
		<br>
		<form:button>Update</form:button>
	</form:form>
</body>
</html>