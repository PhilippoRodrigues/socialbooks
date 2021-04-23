package com.philippo.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philippo.socialbooks.domain.Autor;
import com.philippo.socialbooks.repository.AutoresRepository;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
	}
}
