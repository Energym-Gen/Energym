package com.generation.energym.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
	private @NotBlank String nome;

	@ApiModelProperty(example = "email@email.com.br")
	@NotBlank(message = "O atributo Email é Obrigatório!")
	@Email(message = "O atributo deve ser um email válido!")
	private String email;
	private @NotBlank @Size(min = 5, max = 100) String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<PostagemModel> postagens = new ArrayList<>();

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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<PostagemModel> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<PostagemModel> postagens) {
		this.postagens = postagens;
	}

}
