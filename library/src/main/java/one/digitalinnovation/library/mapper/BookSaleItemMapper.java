package one.digitalinnovation.library.mapper;

import one.digitalinnovation.library.dto.BookSaleItemDTO;
import one.digitalinnovation.library.model.BookSaleItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookSaleItemMapper {


	BookSaleItemMapper INSTANCE = Mappers.getMapper(BookSaleItemMapper.class);

	BookSaleItem toModel(BookSaleItemDTO bookSaleItemDTO);

	@InheritInverseConfiguration
	BookSaleItemDTO toDTO(BookSaleItem bookSaleItem);


}
