package com.philippo.socialbooks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.philippo.socialbooks.client.LivrosClient;
import com.philippo.socialbooks.client.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) throws ParseException {
		
		LivrosClient client =  new LivrosClient("http://localhost:8080", "philippo", "s3nh4");
		
		List<Livro> listaLivros = client.listar();
		
		for (Livro livro : listaLivros) {
			System.out.println("Livro: " + livro.getNome());
		}
		
		Livro livro = new Livro();
		livro.setNome("Domain-Drive Design");
		livro.setEditora("Exemplo");
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("28/04/2021"));
		livro.setResumo("Esse livro aborda métodos de design pattern.");
		
		String localizacao = client.salvar(livro);
		
		System.out.println("URI do livro saldo: " + localizacao);
		
		Livro livroBuscado = client.buscar(localizacao);
		System.out.println("Livro buscado: " + livroBuscado.getNome());
	}
}
