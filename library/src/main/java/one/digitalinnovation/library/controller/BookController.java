package one.digitalinnovation.library.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.library.dto.BookDTO;
import one.digitalinnovation.library.dto.QuantityDTO;
import one.digitalinnovation.library.exception.BookAlreadyRegisteredException;
import one.digitalinnovation.library.exception.BookNotFoundException;
import one.digitalinnovation.library.exception.BookStockExceededException;
import one.digitalinnovation.library.exception.BookStockInsufficientException;
import one.digitalinnovation.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/inventory/books")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

	private final BookService bookService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDTO createBook(@RequestBody @Valid BookDTO bookDTO) throws BookAlreadyRegisteredException {
		return bookService.createBook(bookDTO);
	}

	@GetMapping
	public List<BookDTO> listBooks() {
		return bookService.listAll();
	}

	@GetMapping("/{title}")
	public BookDTO findByTitle(@PathVariable String title) throws BookNotFoundException {
		return bookService.findByTitle(title);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws BookNotFoundException {
		bookService.deleteById(id);
	}

	@PatchMapping("/{id}/increment")
	public BookDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws BookNotFoundException, BookStockExceededException {
		return bookService.increment(id, quantityDTO.getQuantity());
	}

	@PatchMapping("/{id}/decrement")
	public BookDTO decrement(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws BookNotFoundException, BookStockInsufficientException {
		return bookService.decrement(id, quantityDTO.getQuantity());
	}

}
