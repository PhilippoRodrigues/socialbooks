package com.philippo.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.philippo.socialbooks.domain.DetalhesErro;
import com.philippo.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlerLivroNaoEncontradoException(LivroNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("O livro não pode ser encontrado");
		
		//Disponibiliza uma página para dizer ao usuário as informações sobre o erro e como manipulá-lo
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		
		//Quanto maior específico for o tempo, melhor para debugar
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
