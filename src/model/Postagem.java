package model;

public class Postagem {


	private Long id;
	private String titulo;
	private String texto;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Postagem outraPostagem=(Postagem)obj;
		return this.id.equals(outraPostagem.id);
	}

	public String toString() {
		return "  \n titulo:"+ titulo + " \n texto:"+ texto;
	}
	
}
