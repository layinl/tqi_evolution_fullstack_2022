package one.digitalinnovation.library.repository;

import one.digitalinnovation.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {

	Optional<Book> findByTitle(String title);

}
