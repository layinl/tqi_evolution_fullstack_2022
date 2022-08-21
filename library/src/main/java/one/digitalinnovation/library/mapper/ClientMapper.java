package one.digitalinnovation.library.mapper;

import one.digitalinnovation.library.dto.ClientDTO;
import one.digitalinnovation.library.model.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

	Client toModel(ClientDTO clientDTO);

	@InheritInverseConfiguration
	ClientDTO toDTO(Client client);

}
