<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
          <springform:form method="post"  modelAttribute="product" action="${contextPath}/seller/addproduct">
              <c:forEach items="${product['class'].superclass.declaredFields}" var="field">
              <c:out value='${(field.type.name ne "dt.b190043.demoproject.model.User")  && (field.type.name ne "dt.b190043.demoproject.model.SubCategory")}'></c:out>
                <c:if test='${(field.type.name ne "dt.b190043.demoproject.model.User")  && (field.type.name ne "dt.b190043.demoproject.model.SubCategory")}'>
                    
                    ${field.name}<springform:input path="${field.name}"/>
                   <br>
                 </c:if>
              </c:forEach>
             
              <c:forEach items="${product['class'].declaredFields}" var="field">
                     ${field.name}<springform:input path="${field.name}"/>
                    <br>
              </c:forEach>
              <input type="submit" value="Add Product"/>
          </springform:form> 
</body>
</html>