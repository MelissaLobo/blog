<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Postagens</title>

<style>
body {
	background: linear-gradient(to right, silver, skyblue);
	font-family: Times New Roman, sans-serif
}

</style>

<style type="text/css">
h1,h2 {
	color: teal;
}
</style>

</head>
<body>
	<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}<br />
	</c:if>


	<h1>Postagens</h1>
	<br />

	<c:if test="${not empty postagens}">
		<a href="http://localhost:8080/blog/listaDePostagens"></a>
		<div style='margin-top: 4px; margin-bottom: 5px; margin-left: 50px; margin-right: 50px;'>
			<ul>
				<c:forEach var="postagem" items="${postagens}">
					<br />
					<li><font color="teal">${postagem.titulo}<br /></font>
						${postagem.texto } <br /> 
						<a href="http://localhost:8080/blog/mostraPost?idDoPost=${postagem.id}">Comentários</a><br />
					</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>

	<div align="center"><a href="http://localhost:8080/blog/home.jsp">Inicio</a></div>
	<br />

</body>
</html>

