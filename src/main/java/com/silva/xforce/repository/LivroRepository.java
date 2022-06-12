package com.silva.xforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silva.xforce.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
