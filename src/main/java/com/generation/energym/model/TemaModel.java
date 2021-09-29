package com.generation.energym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Size(min = 5, max = 100)
	private String equipamentos;

	private Boolean ativo;

	@NotBlank
	private Float economia;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Float getEconomia() {
		return economia;
	}

	public void setEconomia(Float economia) {
		this.economia = economia;
	}

}
