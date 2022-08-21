package one.digitalinnovation.library.mapper;

import one.digitalinnovation.library.dto.BookSaleDTO;
import one.digitalinnovation.library.model.BookSale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookSaleMapper {

	BookSaleMapper INSTANCE = Mappers.getMapper(BookSaleMapper.class);

	BookSale toModel(BookSaleDTO bookSaleDTO);

	@InheritInverseConfiguration
	BookSaleDTO toDTO(BookSale bookSale);


}
