package fr.bnpparibas.prevoyance.poc.reference.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;
import fr.bnpparibas.prevoyance.poc.reference.model.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(ProductEntity product);

    List<ProductDTO> toProductDTOs(List<ProductEntity> products);

    ProductEntity toProduct(ProductDTO productDTO);
}
