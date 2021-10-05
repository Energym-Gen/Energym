package com.generation.energym.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.energym.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long> {
	
	public List<TemaModel> findAllByEquipamentoContainingIgnoreCase(String equipamento);
}