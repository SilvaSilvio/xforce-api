package com.silva.xforce;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.silva.xforce.domain.Categoria;
import com.silva.xforce.domain.Livro;
import com.silva.xforce.repository.CategoriaRepository;
import com.silva.xforce.repository.LivroRepository;

@SpringBootApplication
public class XforceApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(XforceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Livro l1 = new Livro(null, "Clean Code", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList( l1 ) ) ;
		
		//Salvando varias categorias categoria
		this.categoriaRepository.saveAll(Arrays.asList( cat1 ) );
		
		//Salvando vários livros
		this.livroRepository.saveAll(Arrays.asList( l1 ) );
	}

}
