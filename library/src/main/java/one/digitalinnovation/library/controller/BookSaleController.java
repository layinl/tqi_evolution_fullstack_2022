package one.digitalinnovation.library.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.library.dto.BookSaleDTO;
import one.digitalinnovation.library.exception.BookSaleNotFoundException;
import one.digitalinnovation.library.repository.BookSaleRepo;
import one.digitalinnovation.library.service.BookSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookSaleController {

	BookSaleService bookSaleService;
	private final BookSaleRepo bookSaleRepo;

	@PostMapping
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	public BookSaleDTO createBookSale(@RequestBody @Valid BookSaleDTO bookSaleDTO) {

		return bookSaleService.createBookSale(bookSaleDTO);
	}

	@GetMapping
	@CrossOrigin
	public List<BookSaleDTO> listBookSales() {
		return bookSaleService.listAll();
	}

	@GetMapping("/{id}")
	@CrossOrigin
	public BookSaleDTO findById(@PathVariable Long id) throws BookSaleNotFoundException {
		return bookSaleService.findById(id);
	}

	@DeleteMapping("/{id}")
	@CrossOrigin
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws BookSaleNotFoundException {
		bookSaleService.deleteById(id);
	}

}
