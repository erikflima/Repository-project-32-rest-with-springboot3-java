package com.eriklima.project.exception.handler;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.eriklima.project.exception.ExceptionResponse;
import com.eriklima.project.exception.UnsupportedMathOperationException;

@ControllerAdvice //Essa anotation é usada para tratamento global de exceptions que podem ocorrer em controllers. Ou seja, caso uma exception ocorra dentro de um controler, e não houver um tratamento dessa mesma exception dentro do proprio controler, a classe que tem essa anotação "@ControllerAdvice" vai ser responsável pelo tratamento.
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{ //Manipulador de exceptions que eu criei.
	
	
	//Criando o retorno caso uma excecao do tipo "Exception" ocorra em algum em qualquer controller.
	@ExceptionHandler( Exception.class )
	public final ResponseEntity<ExceptionResponse> handleAllExceptions( Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
																	new Date(),
																	ex.getMessage(),
																	request.getDescription(false) //Pega qual foi a uri recebida na requisicao.
																   );
		
		ResponseEntity<ExceptionResponse> resposta = new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return resposta;
	}
	
	//------------------------------------------
	
	
	//Criando o retorno caso uma excecao do tipo "UnsupportedMathOperationException" ocorra em algum em qualquer controller.
	@ExceptionHandler( UnsupportedMathOperationException.class )
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions( Exception ex, WebRequest request ){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
																	new Date(),
																	ex.getMessage(),
																	request.getDescription(false) //Pega qual foi a uri recebida na requisicao.
																   );
		
		ResponseEntity<ExceptionResponse> resposta = new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
				
		return resposta;
	}

}
