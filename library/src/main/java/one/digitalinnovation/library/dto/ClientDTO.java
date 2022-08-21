package one.digitalinnovation.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.library.model.BookSale;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private Long id;

//	private Set<BookSale> bookSale;

	@NotNull
	@Size(min = 1, max = 200)
	private String name;

	@NotNull
	@Min(value = 13, message = "The client must be at least 13 years old")
	@Max(value = 125, message = "The client must have a valid age")
	private Integer age;

	@NotNull
	private Character gender;

	@NotNull
	@Size(min = 1, max = 200)
	private String address;

}
