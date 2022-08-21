package one.digitalinnovation.library.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.library.dto.ClientDTO;
import one.digitalinnovation.library.exception.ClientAlreadyRegisteredException;
import one.digitalinnovation.library.exception.ClientNotFoundException;
import one.digitalinnovation.library.mapper.ClientMapper;
import one.digitalinnovation.library.model.Client;
import one.digitalinnovation.library.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

	private final ClientRepo clientRepo;

	private final ClientMapper clientMapper = ClientMapper.INSTANCE;


	private void verifyIfItsAlreadyRegistered(String name) throws ClientAlreadyRegisteredException {
		Optional<Client> optSavedClient = clientRepo.findByName(name);
		if(optSavedClient.isPresent()) throw new ClientAlreadyRegisteredException(name);
	}

	private Client verifyIfExists(Long id) throws ClientNotFoundException{
		return clientRepo.findById(id)
			.orElseThrow(() -> new ClientNotFoundException(id));
	}

	public ClientDTO createClient(ClientDTO clientDTO) throws ClientAlreadyRegisteredException {
		verifyIfItsAlreadyRegistered(clientDTO.getName());
		Client client = clientMapper.toModel(clientDTO);
		Client savedClient = clientRepo.save(client);
		return clientMapper.toDTO(savedClient);
	}

	public ClientDTO findByName(String name) throws ClientNotFoundException {
		Client foundClient = clientRepo.findByName(name)
			.orElseThrow(() -> new ClientNotFoundException(name));
		return clientMapper.toDTO(foundClient);
	}

	public List<ClientDTO> listAll() {
		return clientRepo.findAll()
			.stream()
			.map(clientMapper::toDTO)
			.collect(Collectors.toList());
	}

	public void deleteById(Long id) throws ClientNotFoundException {
		verifyIfExists(id);
		clientRepo.deleteById(id);
	}


}
