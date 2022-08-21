package one.digitalinnovation.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookStockInsufficientException extends Exception {

	public BookStockInsufficientException(Long id, int decrementQuantity) {
		super(String.format("Books with %s ID to decrement informed exceeds the amount available: %s", id, decrementQuantity));
	}

}
