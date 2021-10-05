package com.generation.energym.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class UsuarioModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
	private @NotBlank String nome;
	private @Email String email;
	private @NotBlank @Size(min = 5 , max = 100 ) String senha;
	
	@OneToMany(mappedBy = "criador", cascade = CascadeType.REMOVE )
	private List<PostagemModel> minhasPostagens = new ArrayList<>();

	public Long getId() {
		return idUsuario;
	}

	public void setId(Long id) {
		this.idUsuario = id;
	}

	public String getNome() {
		return nome;
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

	public List<PostagemModel> getMinhasPostagens() {
		return minhasPostagens;
	}

	public void setMinhasPostagens(List<PostagemModel> minhasPostagens) {
		this.minhasPostagens = minhasPostagens;
	}
	
}
