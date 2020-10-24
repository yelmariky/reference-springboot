package fr.bnpparibas.prevoyance.poc.reference.mappers;

import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;
import fr.bnpparibas.prevoyance.poc.reference.model.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-24T23:43:12+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName( product.getName() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setPrice( product.getPrice() );

        return productDTO;
    }

    @Override
    public List<ProductDTO> toProductDTOs(List<ProductEntity> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( ProductEntity productEntity : products ) {
            list.add( toProductDTO( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductEntity toProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName( productDTO.getName() );
        productEntity.setDescription( productDTO.getDescription() );
        productEntity.setPrice( productDTO.getPrice() );

        return productEntity;
    }
}
