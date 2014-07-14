package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.Comentario;
import model.Postagem;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/mostraPost")
public class MostraPost extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		try {

			Long id = Long.parseLong(req.getParameter("idDoPost"));
			Blog blog = new Blog();

			Postagem post = blog.buscaPostPorID(id);
			List<Comentario> lista = blog.buscaComentariosDoPostPorID(id);

			req.setAttribute("comentarios", lista);
			req.setAttribute("postagem", post);

			direcionaParaHtml(req, resp, "/mostraPost.jsp");

		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			direcionaParaHtml(req, resp, "erro.jsp");
		}

	}

}
