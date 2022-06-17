package com.silva.xforce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.silva.xforce.domain.Categoria;
import com.silva.xforce.dtos.CategoriaDTO;
import com.silva.xforce.repository.CategoriaRepository;
import com.silva.xforce.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	// Faz a busca por id na entidade categoria
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! " + id + ", Tipo: " + Categoria.class.getName()));
	}

	// Busca todas os registros na entidade categoria...
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria updateCategoria(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj);
	}

	// Metodo que delete um registro da entidade categoria passado o id..
	public void deleteCategoria(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
		
			throw new com.silva.xforce.service.exception.DataIntegrityViolationException("Categoria não pode ser deletado! Pois possui livros associadoss");
				}
		
		
	}

}
