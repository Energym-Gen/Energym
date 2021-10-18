package com.generation.energym.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.energym.model.UsuarioLogin;
import com.generation.energym.model.UsuarioModel;
import com.generation.energym.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

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

}
