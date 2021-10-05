package com.generation.energym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.energym.model.PostagemModel;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long>{
	
	
	/**
	 * Metodo utilizado para realizar pesquisa pela coluna equioamentos da tabela postagem
	 * 
	 * @param equipamento
	 * @return List com equipamentos
	 * @author Gabriela 
	 */
	

	public List<PostagemRepository> findAllByTextoContainingIgnoreCase(String Texto);
	
	
	
	/**
	 * Metodo utilizado para realizar pesquisa pela coluna titulo da tabela postagem
	 * 
	 * @param titulo
	 * @return List de titulos
	 * @author Gabriela,Vitor
	 */
	
	public List<PostagemRepository> findAllByTituloContainingIgnoreCase(String titulo);
	
}
