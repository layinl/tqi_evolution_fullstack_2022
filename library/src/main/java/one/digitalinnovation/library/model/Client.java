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
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	/*@OneToMany(cascade = {CascadeType.MERGE}, fetch= FetchType.EAGER, mappedBy = "client")
	private Set<BookSale> bookSale;*/

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "gender", nullable = false)
	private Character gender;

	@Column(name = "address", nullable = false)
	private String address;

}
