package com.silva.xforce.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.xforce.domain.Categoria;
import com.silva.xforce.domain.Livro;
import com.silva.xforce.repository.CategoriaRepository;
import com.silva.xforce.repository.LivroRepository;

@Service
public class DBService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat2 = new Categoria(null, "Literaturas", "Livros de Portugues");
		Livro l1 = new Livro(null, "A moreninha", "Lorem ipsum", cat2);
		
		cat2.getLivros().addAll(Arrays.asList( l1 ) ) ;
		
		//Salvando varias categorias categoria
		this.categoriaRepository.saveAll(Arrays.asList( cat2 ) );
		
		//Salvando vários livros
		this.livroRepository.saveAll(Arrays.asList( l1 ) );
	}

}
