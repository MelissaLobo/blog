<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comentarios</title>

<style>
body {
	background: linear-gradient(to right, silver, skyblue);
}

</style>

<style type="text/css">
h1,h2 {
	color: teal;
}
</style>

</head>

<body>

	<h1>${postagem.titulo}</h1>
	<br />
    <br/>
	<br/> ${postagem.texto }
	 <br/> <br/>
	<h1>Comentarios</h1>
	<br />
   
	<c:if test="${not empty comentarios}">
		<a href="http://localhost:8080/blog/listaDeComentarios"></a>
		<ul>
			<c:forEach var="comentario" items="${comentarios}">
				<br />
				<li>${comentario.nome}<br /> ${comentario.texto }
				</li>
			</c:forEach>
		</ul>
	</c:if>
	
	    <h1>Publicar um comentário:</h1>
	<form action="http://localhost:8080/blog/comentar" method="POST">
	    <input type="hidden" name="idDoPost" value="${postagem.id}">
		Nome: <input type="text" name="nome"> <br/>
		<textarea name="texto" rows="5" cols="50" style="background-color: #ffffff"> ESCREVA AQUI O SEU COMENTARIO</textarea><br/>
		<input type="submit" value="Publicar">
	</form>

<div align="center"><a href="http://localhost:8080/blog/home.jsp">Inicio</a></div>

</body>
</html>