<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style> 
body {background: linear-gradient(to right, silver, skyblue);}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Erros</title>
</head>
<body>

	<c:if test="${not empty erro}">
			${erro}
</c:if>
<br/>
<br/>
<a href="http://localhost:8080/blog/login.jsp">Faça seu login</a> ou
<a href="http://localhost:8080/blog/cadastro.jsp">Cadastre-se</a>
</body>
</html>