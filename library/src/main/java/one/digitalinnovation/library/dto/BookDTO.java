package one.digitalinnovation.library.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.library.model.Book;
import one.digitalinnovation.library.model.BookSale;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

	private Long id;

//	private Set<BookSale> bookSale;

	@NotNull
	@Size(min = 1, max = 200)
	private String title;

	@NotNull
	@Size(min = 1, max = 200)
	private String author;

	@NotNull
	@Size(min = 1, max = 200)
	private String publisher;

	@NotNull
	@Size(min = 1, max = 200)
	private String coverImage;

	@NotNull
	@Size(min = 1, max = 200)
	private String publishYear;

	@NotNull
	private Double unitValue;

	@NotNull
	@Min(value = 0)
	@Max(value = 100, message = "Quantity can't be greater than 100")
	private Integer quantity;

	@NotNull
	@Min(value = 1, message = "Maximum should be greater than 0")
	@Max(value = 100, message = "Maximum can't be greater than 100")
	private Integer max;

}
