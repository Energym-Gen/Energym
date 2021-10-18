package com.generation.energym.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.energym.repository.UsuarioRepository;
import com.generation.energym.model.UsuarioLogin;
import com.generation.energym.model.UsuarioModel;
import com.generation.energym.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository repository;

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrar(@Valid @RequestBody UsuarioModel usuario) {
		return usuarioService.cadastrarUsuario(usuario)
				.map(usuarioExistente -> ResponseEntity.status(201).body(usuarioExistente)).orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Usuario existente, cadastre outro usuario!.");
				});
	}

	@GetMapping
	public ResponseEntity<List<UsuarioModel>> buscarTodosUsuarios() {
		List<UsuarioModel> objetoLista = repository.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		return repository.findById(idUsuario).map(idExistente -> ResponseEntity.status(200).body(idExistente))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND,
							"ID inexistente, passe um ID valido para pesquisa!.");
				});
	}

	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioModel> atualizar(@Valid @RequestBody UsuarioModel usuario) {
		return usuarioService.atualizarUsuario(usuario)
				.map(usuarioExistente -> ResponseEntity.status(201).body(usuarioExistente)).orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Necessario que passe um Usuario válido para alterar!.");
				});
	}

	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
		return repository.findById(idUsuario).map(idExistente -> {
			repository.deleteById(idUsuario);
			return ResponseEntity.status(200).build();
		}).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID inexistente, passe um ID valido para deletar!");
		});
	}

}
