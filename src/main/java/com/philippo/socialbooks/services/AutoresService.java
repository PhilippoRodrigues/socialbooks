package com.philippo.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philippo.socialbooks.domain.Autor;
import com.philippo.socialbooks.repository.AutoresRepository;
import com.philippo.socialbooks.services.exceptions.AutorExistenteException;
import com.philippo.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			Autor a = autoresRepository.findById(autor.getId()).orElse(null);
			
			if (a != null) {
				throw new AutorExistenteException("Autor já existe.");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autoresRepository.findById(id).orElse(null);
		
		if (autor == null) {
			throw new AutorNaoEncontradoException("Autor não foi encontrado.");
		}
		return autor;
	}
}
