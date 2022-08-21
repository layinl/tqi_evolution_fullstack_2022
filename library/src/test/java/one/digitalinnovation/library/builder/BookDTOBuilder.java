package one.digitalinnovation.library.builder;

import lombok.Builder;
import one.digitalinnovation.library.dto.BookDTO;
import one.digitalinnovation.library.model.BookSale;

import java.util.Set;

@Builder
public class BookDTOBuilder {

	@Builder.Default
	private Long id = 1L;

	@Builder.Default
	private Set<BookSale> bookSale = null;

	@Builder.Default
	private String title = "Divergent";

	@Builder.Default
	private String author = "Veronoca Roth";

	@Builder.Default
	private String publisher = "Rocco";

	@Builder.Default
	private String coverImage = "img.jpg";

	@Builder.Default
	private String publishYear = "2012";

	@Builder.Default
	private Double unitValue = 30.0;

	@Builder.Default
	private Integer quantity = 50;

	@Builder.Default
	private Integer max = 100;

	public BookDTO toBookDTO() {
		return new BookDTO(id, bookSale, title, author, publisher,coverImage, publishYear, unitValue, quantity, max);
	}


}
