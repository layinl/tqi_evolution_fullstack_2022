package one.digitalinnovation.library.repository;

import one.digitalinnovation.library.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long> {

	Optional<Client> findByName(String name);

}
