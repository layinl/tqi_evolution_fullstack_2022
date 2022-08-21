package one.digitalinnovation.library.exception;

public class BookSaleNotFoundException extends Exception {

	public BookSaleNotFoundException(Long id) {
		super(String.format("Book sale with id %s not found in the system.", id));
	}

}
