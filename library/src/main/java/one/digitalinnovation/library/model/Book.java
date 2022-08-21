package one.digitalinnovation.library.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", nullable = false)
	private Long id;

	/*@ManyToMany(cascade = {CascadeType.MERGE},fetch= FetchType.EAGER)
	@JoinTable(name = "book_has_book_sales", joinColumns=
		{@JoinColumn(name="book_id")}, inverseJoinColumns=
		{@JoinColumn(name="book_sale_id")})
	@Column(name = "book_sale")
	private Set<BookSale> bookSale;*/

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private String publisher;

	@Column(nullable = false)
	private String coverImage;

	@Column(nullable = false)
	private String publishYear;

	@Column(name = "unit_value", nullable = false)
	private Double unitValue;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "max", nullable = false)
	private Integer max;

}
