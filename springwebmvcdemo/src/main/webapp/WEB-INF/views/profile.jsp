<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <table>
        	<tr>
        		<td><label>Username</label></td>
        		<td>${user.username}</td>
        	</tr>
        	<tr>
        		<td><label>Email</label></td>
        		<td>${user.email }</td>
        	</tr>
        	<tr>
        		<td><label>Mobile</label></td>
        		<td>${user.mobile }</td>
        	</tr>
        	<tr>
        		<td><label>Role</label></td>
        		<td>${user.role}</td>
        	</tr>
        	<tr>
        		<td colspan=""><a href="edit"><button>Edit</button></a></td>
        	</tr>
        	
        </table>
</body>
</html>