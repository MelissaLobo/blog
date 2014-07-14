<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style> 
body {background: linear-gradient(to right, silver, skyblue);}
</style>

<style type="text/css">
h1,h2 {
	color: teal;
	font-size: 30px;
}
</style>

</head>
<body>
<c:if test="${not empty usuarioLogado}">
	Blog de ${usuarioLogado.email}<br/>
</c:if>

<h1>Bem Vindo ao Blog!</h1><br/>


<a href="http://localhost:8080/blog/listaDePostagens">Visualizar Blog</a><br/>
<a href="http://localhost:8080/blog/postagens.jsp">Novo Post</a><br/>
<a href="http://localhost:8080/blog/cadastro.jsp">Novo Blog</a>	<br/>

<form action="http://localhost:8080/blog/deslogar" method="POST">
		<input type="hidden" name="logout" value="Logout" /> 
		<input type="submit" value="Deslogar" />
	</form>

</body>
</html>