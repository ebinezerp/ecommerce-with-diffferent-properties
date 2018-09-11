<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<springform:form action="update" method="post" modelAttribute="user">
<table>
	<tr>
		<td>Username</td>
		<td><springform:input path="username"/></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr><td><springform:password  path="password" type="hidden"/></td></tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update"></td>
	</tr>
</table>

</springform:form>



</body>
</html>