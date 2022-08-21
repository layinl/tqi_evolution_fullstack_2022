package one.digitalinnovation.library.service;

import one.digitalinnovation.library.builder.BookDTOBuilder;
import one.digitalinnovation.library.dto.BookDTO;
import one.digitalinnovation.library.exception.BookAlreadyRegisteredException;
import one.digitalinnovation.library.mapper.BookMapper;
import one.digitalinnovation.library.model.Book;
import one.digitalinnovation.library.repository.BookRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepo bookRepo;

	private final BookMapper bookMapper = BookMapper.INSTANCE;

	@InjectMocks
	private BookService bookService;

	@Test
	void whenBookInformedThenItShouldBeCreated() throws BookAlreadyRegisteredException {

		BookDTO expectedBookDTO = BookDTOBuilder.builder().build().toBookDTO();
		Book expectedSavedBook = bookMapper.toModel(expectedBookDTO);
		// when
		Mockito.when(bookRepo.findByTitle(expectedBookDTO.getTitle())).thenReturn(Optional.empty());
		Mockito.when(bookRepo.save(expectedSavedBook)).thenReturn(expectedSavedBook);
		//then
		BookDTO createdBeerDTO = bookService.createBook(expectedBookDTO);

		assertThat(createdBeerDTO.getId(), is(expectedBookDTO.getId()));
		assertThat(createdBeerDTO.getTitle(), is(expectedBookDTO.getTitle()));
		assertThat(createdBeerDTO.getQuantity(), is(expectedBookDTO.getQuantity()));

		BookDTO createBeerDTO = bookService.createBook(expectedBookDTO);
		assertEquals(expectedBookDTO.getId(), createBeerDTO.getId());

	}

}
