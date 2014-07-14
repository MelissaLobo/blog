package persistencia;

import java.util.List;

import model.Comentario;
import model.Postagem;
import model.Usuario;

public interface BlogDAO {

	Postagem salvarPost(Postagem postagem, Usuario usuario);

	Comentario salvarComentario(Comentario comentario, int idDoPost);

	List<Postagem> listagemDePostagens(Usuario usuario);

	List<Comentario> listagemDeComentariosPorId(Long id);

	Postagem buscaPostPorID(Long id);
}
