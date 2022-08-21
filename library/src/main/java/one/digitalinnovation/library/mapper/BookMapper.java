package one.digitalinnovation.library.mapper;

import one.digitalinnovation.library.dto.BookDTO;
import one.digitalinnovation.library.model.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

	Book toModel(BookDTO bookDTO);

	@InheritInverseConfiguration
	BookDTO toDTO(Book book);

}
