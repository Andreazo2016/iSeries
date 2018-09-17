package iseries.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value= HttpStatus.NOT_FOUND)
	@ResponseBody
	public String requestHandlingNoHandlerFound() {
		return "Desculpe Página Não Encontrada";
	}
}
