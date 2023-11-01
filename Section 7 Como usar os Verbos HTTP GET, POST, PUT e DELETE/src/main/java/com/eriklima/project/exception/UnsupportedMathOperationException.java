package com.eriklima.project.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //Retorne esse status code caso a exception ocorrer.
public class UnsupportedMathOperationException extends RuntimeException{ //Exception que eu criei.

	public UnsupportedMathOperationException( String mensagemDeErro ){
		
		super(mensagemDeErro);
	}

	private static final long serialVersionUID = 1L;
}