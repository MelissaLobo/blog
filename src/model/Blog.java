package model;
import java.util.List;

import persistencia.BlogDAO;
import persistencia.BlogBancoDeDadosDao;

public class Blog {
	
	BlogDAO banco = new BlogBancoDeDadosDao();

	public void adicionarComentario(String nome, String texto, int idDoPost) {
		
		Comentario comentarios = new Comentario();
		comentarios.setNome(nome);
		comentarios.setTexto(texto);
	
		banco.salvarComentario(comentarios, idDoPost);
					
	}
	public void adicionarPostagem(String titulo, String texto, Usuario usuario){
		
		Postagem postagem = new Postagem();
		postagem.setTitulo(titulo);
		postagem.setTexto(texto);
		
		banco.salvarPost(postagem, usuario);
	}
	public List<Postagem> listaDePostagens(Usuario usuario) {

		return banco.listagemDePostagens(usuario);
		
	}

	public Postagem buscaPostPorID(Long id) {
		return banco.buscaPostPorID(id);
		
	}
	public List<Comentario> buscaComentariosDoPostPorID(Long id) {
		return banco.listagemDeComentariosPorId(id);
	}
		
		
	}
	