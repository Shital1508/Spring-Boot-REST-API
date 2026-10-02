package SpringRest.Exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppException {
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e)
	{
		return e.getMessage();
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String,String>> handleMethodArgumentException(MethodArgumentNotValidException e)
	{
		HashMap<String,String> errors =new HashMap<String,String>();
		
		e.getBindingResult().getFieldErrors().forEach(error->
		{
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<HashMap<String,String>>(errors,HttpStatus.BAD_REQUEST);
	}

}
