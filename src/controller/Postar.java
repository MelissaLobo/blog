package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.Usuario;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/postar")
public class Postar extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		try {

			String titulo = req.getParameter("titulo");
			String texto = req.getParameter("texto");

			Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");

			Blog blog = new Blog();
			blog.adicionarPostagem(titulo, texto, usuario);

			direcionaParaHtml(req, resp, "/listaDePostagens.jsp");
			
		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			direcionaParaHtml(req, resp, "erro.jsp");
		}
	}
}
