package com.silva.xforce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.xforce.domain.Categoria;
import com.silva.xforce.repository.CategoriaRepository;

@Service
public class CategoriaService {

		@Autowired
		private CategoriaRepository categoriaRepository;
		
		public Categoria findById(Integer id) {
			Optional<Categoria> obj = categoriaRepository.findById(id);
			return obj.orElse(null);
		}
	
}
