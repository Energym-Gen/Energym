package com.generation.energym.model;

public class UsuarioLogin {
	
	private long usuarioID;

	private String nome;

	private String email;

	private String senha;

	private String token;

	public String getNome() {
		return nome;
	}

	public long getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(long usuarioID) {
		this.usuarioID = usuarioID;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
