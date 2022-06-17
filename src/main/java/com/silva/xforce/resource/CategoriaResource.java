package com.silva.xforce.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.silva.xforce.domain.Categoria;
import com.silva.xforce.dtos.CategoriaDTO;
import com.silva.xforce.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = categoriaService.findAll();
		// Converte uma Categoria em Categoria DTO
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	// Metodo responsável por salvar uma categoria.
	@PostMapping
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria obj) {
		obj = categoriaService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}
	
	//Atualização de Cagetoria
	@PutMapping(value= "/{id}")
	public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO objDTO){
		Categoria categ = categoriaService.updateCategoria(id, objDTO);
		return ResponseEntity.ok().body(new CategoriaDTO(categ));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
		categoriaService.deleteCategoria(id);
		return ResponseEntity.noContent().build();
		
	}
	
	

}
