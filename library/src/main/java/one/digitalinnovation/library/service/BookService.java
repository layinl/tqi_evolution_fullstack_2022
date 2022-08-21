package one.digitalinnovation.library.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.library.dto.BookDTO;
import one.digitalinnovation.library.exception.BookAlreadyRegisteredException;
import one.digitalinnovation.library.exception.BookNotFoundException;
import one.digitalinnovation.library.exception.BookStockExceededException;
import one.digitalinnovation.library.exception.BookStockInsufficientException;
import one.digitalinnovation.library.mapper.BookMapper;
import one.digitalinnovation.library.model.Book;
import one.digitalinnovation.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

	private final BookRepo bookRepo;

	private final BookMapper bookMapper = BookMapper.INSTANCE;

	private void verifyIfItsAlreadyRegistered(String title) throws BookAlreadyRegisteredException {
		Optional<Book> optSavedBook = bookRepo.findByTitle(title);
		if(optSavedBook.isPresent()) throw new BookAlreadyRegisteredException(title);
	}

	private Book verifyIfExists(Long id) throws BookNotFoundException {
		return bookRepo.findById(id)
			.orElseThrow(() -> new BookNotFoundException(id));
	}

	public BookDTO createBook(BookDTO bookDTO) throws BookAlreadyRegisteredException {
		verifyIfItsAlreadyRegistered(bookDTO.getTitle());
		Book book = bookMapper.toModel(bookDTO);
		Book savedBook = bookRepo.save(book);
		return bookMapper.toDTO(savedBook);
	}

	public BookDTO findByTitle(String title) throws BookNotFoundException {
		Book foundBook = bookRepo.findByTitle(title)
			.orElseThrow(() -> new BookNotFoundException(title));
		return bookMapper.toDTO(foundBook);
	}

	public List<BookDTO> listAll() {
		return bookRepo.findAll()
			.stream()
			.map(bookMapper::toDTO)
			.collect(Collectors.toList());
	}

	public void deleteById(Long id) throws BookNotFoundException {
		verifyIfExists(id);
		bookRepo.deleteById(id);
	}

	public BookDTO increment(Long id, int incrementQuantity) throws BookNotFoundException, BookStockExceededException {
		Book bookToIncrement = verifyIfExists(id);
		int quantityAfterIncrement = incrementQuantity + bookToIncrement.getQuantity();
		if (quantityAfterIncrement <= bookToIncrement.getMax()) {
			bookToIncrement.setQuantity(bookToIncrement.getQuantity() + incrementQuantity);
			Book incrementedBeerStock = bookRepo.save(bookToIncrement);
			return bookMapper.toDTO(incrementedBeerStock);
		}
		throw new BookStockExceededException(id, incrementQuantity);
	}

	public BookDTO decrement(Long id, int decrementQuantity) throws BookNotFoundException, BookStockInsufficientException {
		Book bookToDecrement = verifyIfExists(id);
		int quantityAfterDecrement = bookToDecrement.getQuantity() - decrementQuantity;
		if (quantityAfterDecrement <= bookToDecrement.getMax()) {
			bookToDecrement.setQuantity(bookToDecrement.getQuantity() - decrementQuantity);
			Book incrementedBeerStock = bookRepo.save(bookToDecrement);
			return bookMapper.toDTO(incrementedBeerStock);
		}
		throw new BookStockInsufficientException(id, decrementQuantity);
	}

}
