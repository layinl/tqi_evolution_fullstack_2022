package one.digitalinnovation.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.library.model.BookSaleItem;
import one.digitalinnovation.library.model.Client;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookSaleDTO {

	private Long id;

	@NotNull
	@Size(min = 1)
	private Set<BookSaleItem> bookSaleItems;

	@NotNull
	private Client client;

	@NotNull
	@Min(value = 0)
	private Double totalValue;

}
