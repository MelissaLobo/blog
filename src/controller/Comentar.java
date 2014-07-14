package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/comentar")
public class Comentar extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		try {

			String nome = req.getParameter("nome");
			String texto = req.getParameter("texto");
			String id = req.getParameter("idDoPost");

			Blog blog = new Blog();
			blog.adicionarComentario(nome, texto, Integer.parseInt(id));

			resp.sendRedirect("mostraPost?idDoPost=" + id);

		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			direcionaParaHtml(req, resp, "erro.jsp");
		}

	}

}
