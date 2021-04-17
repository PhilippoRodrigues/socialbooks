package com.philippo.socialbooks.resources;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philippo.socialbooks.domain.Livro;

import repository.LivrosRepository;

@RestController
public class LivrosResources {
	
	private LivrosRepository livrosRepository;
	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}
}
