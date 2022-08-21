package one.digitalinnovation.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.library.model.Book;
import one.digitalinnovation.library.model.BookSale;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookSaleItemDTO {


	private Long id;

	@NotNull
	private Book book;

	@NotNull
	private BookSale bookSale;

	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	private Integer quantity;

}
