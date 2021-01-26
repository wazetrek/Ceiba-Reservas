package com.ceiba.ceibahs.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ExceptionHandler {

	private static final String ERROR_INESPERADO_CONTACTAR_ADMIN="Error inesperado servicio de reservas, contacta al admin";
	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO= new ConcurrentHashMap<>();

	public ExceptionHandler(){
		CODIGOS_ESTADO.put(ObligatoryFieldException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllException(Exception exception) {
		System.out.println(exception);

		ResponseEntity<Error> resultado;
		
		String excepcionNombre=exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);
		
		if(codigo != null){
			Error error = new Error(excepcionNombre, mensaje);
			resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		}else{
			Error error = new Error(excepcionNombre, ERROR_INESPERADO_CONTACTAR_ADMIN);
			resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resultado;
	}
}
