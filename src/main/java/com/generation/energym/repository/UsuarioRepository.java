package com.generation.energym.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.energym.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	/**
	 *  Metodo utilizado para realizar pesquisa pela coluna email da tabela usuario
	 *  
	 * @param email
	 * @return Optional com Usuario
	 * @author Gabriela
	 */
	

	public Optional<UsuarioModel> findByEmail(String email);
	
	/**
	 * Metodo utilizado para realizar spesquisa pela coliuna nome da tabela usuario
	 *  
	 * @param email
	 * @return Optional com Usuario
	 * @author Gabriela
	 */
	
	
	
	
	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);
	
}
