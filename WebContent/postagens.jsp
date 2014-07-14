<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Postagens</title>
<style> 
body {background: linear-gradient(to right, silver, skyblue);}
</style>

<style type="text/css">
h1,h2 {
	color: teal;
}
</style>
</head>
<body>

<h1>Java Blog</h1>

<h3>Novo Post</h3>
	<form action="http://localhost:8080/blog/postar" method="POST">
		Postagem <input type="text" name="titulo"/> <br/>
		<br/>
		<textarea name="texto" rows="5" cols="50" style="background-color: #ffffff" > ESCREVA AQUI O SEU TEXTO</textarea><br/>
		<input type="submit" value="Publicar" /><br/>
	</form>


<div align="center"><a href="http://localhost:8080/blog/home.jsp">Inicio</a></div>


</body>
</html>