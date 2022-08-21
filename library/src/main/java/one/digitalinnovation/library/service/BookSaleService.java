package one.digitalinnovation.library.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.library.dto.BookSaleDTO;
import one.digitalinnovation.library.exception.BookSaleNotFoundException;
import one.digitalinnovation.library.mapper.BookSaleMapper;
import one.digitalinnovation.library.model.BookSale;
import one.digitalinnovation.library.repository.BookRepo;
import one.digitalinnovation.library.repository.BookSaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookSaleService {


	private final BookSaleRepo bookSaleRepo;
	private final BookRepo bookRepo;

	private final BookSaleMapper bookSaleMapper = BookSaleMapper.INSTANCE;
/*
	private void verifyIfItsAlreadyRegistered(Long id) throws ClientAlreadyRegisteredException {
		Optional<BookSale> optSavedBookSale = bookSaleRepo.findById(id);
		if(optSavedClient.isPresent()) throw new ClientAlreadyRegisteredException(name);
	}*/

	private BookSale verifyIfExists(Long id) throws BookSaleNotFoundException {
		return bookSaleRepo.findById(id)
			.orElseThrow(() -> new BookSaleNotFoundException(id));
	}

	public BookSaleDTO createBookSale(BookSaleDTO bookSaleDTO) {
		//verifyIfItsAlreadyRegistered(bookSale.getId());
		BookSale bookSale = bookSaleMapper.toModel(bookSaleDTO);
		BookSale savedBookSale = bookSaleRepo.save(bookSale);
		return bookSaleMapper.toDTO(savedBookSale);
	}

	public BookSaleDTO findById(Long id) throws BookSaleNotFoundException {
		BookSale foundBookSale = bookSaleRepo.findById(id)
			.orElseThrow(() -> new BookSaleNotFoundException(id));
		return bookSaleMapper.toDTO(foundBookSale);
	}

	public List<BookSaleDTO> listAll() {
		return bookSaleRepo.findAll()
			.stream()
			.map(bookSaleMapper::toDTO)
			.collect(Collectors.toList());
	}

	public void deleteById(Long id) throws BookSaleNotFoundException {
		verifyIfExists(id);
		bookSaleRepo.deleteById(id);
	}



}
