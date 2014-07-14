package persistencia;

import static util.Ferramentas.getConection;
import static util.Ferramentas.releaseDatabaseResources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Comentario;
import model.Postagem;
import model.Usuario;

public class BlogBancoDeDadosDao implements BlogDAO {

	@Override
	public Comentario salvarComentario(Comentario comentario, int idDoPost) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "INSERT INTO comentarios (nome, texto, postagens_id) VALUES (?, ?, ?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, comentario.getNome());
			statement.setString(2, comentario.getTexto());
			statement.setLong(3, idDoPost);
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			long key = keys.getLong(1);
			keys.close();
			comentario.setId(key);

		} catch (Exception e) {
			throw new RuntimeException("Erro ao adicionar comentario", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return comentario;
	}

	@Override
	public Postagem salvarPost(Postagem postagem, Usuario usuario) {

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConection();
			String sql = "INSERT INTO postagens (titulo, texto, usuario_id ) VALUES (?, ?, ?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, postagem.getTitulo());
			statement.setString(2, postagem.getTexto());
			statement.setLong(3, usuario.getId());
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			long key = keys.getLong(1);
			keys.close();
			postagem.setId(key);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao postar", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}		
		return postagem;
	}

	@Override
	public List<Postagem> listagemDePostagens(Usuario usuario) {
		List<Postagem> postagem = new ArrayList<Postagem>();
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "SELECT * FROM postagens WHERE usuario_id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, usuario.getId());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()){
				Postagem post = new Postagem();
				post.setTitulo(resultSet.getString("titulo"));
				post.setTexto(resultSet.getString("texto"));
				post.setId(resultSet.getLong("id"));
				postagem.add(post);
			}
			resultSet.close();		
		} catch (Exception e) {
			throw new RuntimeException("Erro ao visualizar postagens", e);
		} finally {
			releaseDatabaseResources(statement, connection);	
		}
		return postagem;
	}

	@Override
	public List<Comentario> listagemDeComentariosPorId(Long id) {
		List<Comentario> comentarios = new ArrayList<Comentario>();
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "SELECT * FROM comentarios where POSTAGENS_ID=?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				Comentario coment = new Comentario();
				coment.setNome(resultSet.getString("nome"));
				coment.setTexto(resultSet.getString("texto"));
				coment.setId(resultSet.getLong("id"));
				comentarios.add(coment);
		}
		resultSet.close();		
	} catch (Exception e) {
		throw new RuntimeException("Erro comentários indisponiveis no momento", e);
	} finally {
		releaseDatabaseResources(statement, connection);	
	}
	return comentarios;
}

	@Override
	public Postagem buscaPostPorID(Long id) {
        Postagem postagem = null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "SELECT * FROM postagens where id=?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()){
				postagem = new Postagem();
				postagem.setTitulo(resultSet.getString("titulo"));
				postagem.setTexto(resultSet.getString("texto"));
				postagem.setId(resultSet.getLong("id"));
			}
			resultSet.close();		
		} catch (Exception e) {
			throw new RuntimeException("Erro ", e);
		} finally {
			releaseDatabaseResources(statement, connection);	
		}
		return postagem;
	}
}