package one.digitalinnovation.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookSale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_id", nullable = false)
	private Long id;

	@OneToMany
	private Set<BookSaleItem> bookSaleItems;

	@ManyToOne
	private Client client;

	@Column(nullable = false)
	private Double totalValue;

}
