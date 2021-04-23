package com.philippo.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philippo.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
