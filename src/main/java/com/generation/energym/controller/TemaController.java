package com.generation.energym.controller;

import java.util.List;

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
import com.generation.energym.model.TemaModel;
import com.generation.energym.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

	@Autowired
	TemaRepository repository;

	// Get all
	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// Get by id
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> GetById(@Valid @PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// Get by equipamento (nome)
	@GetMapping("/equipamento/{equipamento}")
	public ResponseEntity<List<TemaModel>> GetByEquipamento(@Valid @PathVariable String equipamento) {
		return ResponseEntity.ok(repository.findAllByEquipamentoContainingIgnoreCase(equipamento));
	}

	// Post
	@PostMapping
	public ResponseEntity<TemaModel> Post(@Valid @RequestBody TemaModel tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	//Put
	@PutMapping
	public ResponseEntity<TemaModel> Put(@RequestBody TemaModel tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	//Delete using id
	@DeleteMapping("/{id}")
	public void delete (@Valid @PathVariable long id) {
		repository.deleteById(id);
	}
	

}
