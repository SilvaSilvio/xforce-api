package com.silva.xforce.domain;

public class Livro {
	private Integer id;
	private String titulo;
	private String texto;
	private Categoria categoria;

	public Livro() {

	}

	public Livro(Integer id, String titulo, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}