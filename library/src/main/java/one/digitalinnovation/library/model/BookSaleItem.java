package one.digitalinnovation.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookSaleItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_item_id", nullable = false)
	private Long id;

	@ManyToOne
//	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne
//	@JoinColumn(name = "sale_id")
	private BookSale bookSale;

	@Column(nullable = false)
	private Integer quantity;


}
