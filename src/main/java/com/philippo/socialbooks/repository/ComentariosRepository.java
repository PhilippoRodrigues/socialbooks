package com.philippo.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philippo.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
