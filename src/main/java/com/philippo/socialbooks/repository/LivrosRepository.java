package com.philippo.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philippo.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
