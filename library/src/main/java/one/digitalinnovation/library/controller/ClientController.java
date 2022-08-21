package one.digitalinnovation.library.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.library.dto.BookDTO;
import one.digitalinnovation.library.dto.ClientDTO;
import one.digitalinnovation.library.exception.BookAlreadyRegisteredException;
import one.digitalinnovation.library.exception.BookNotFoundException;
import one.digitalinnovation.library.exception.ClientAlreadyRegisteredException;
import one.digitalinnovation.library.exception.ClientNotFoundException;
import one.digitalinnovation.library.model.Client;
import one.digitalinnovation.library.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {


	private final ClientService clientService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientDTO createBook(@RequestBody @Valid ClientDTO clientDTO) throws ClientAlreadyRegisteredException {
		return clientService.createClient(clientDTO);
	}

	@GetMapping
	public List<ClientDTO> listBooks() {
		return clientService.listAll();
	}

	@GetMapping("/{name}")
	public ClientDTO findByTitle(@PathVariable String name) throws ClientNotFoundException {
		return clientService.findByName(name);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws ClientNotFoundException {
		clientService.deleteById(id);
	}

}
