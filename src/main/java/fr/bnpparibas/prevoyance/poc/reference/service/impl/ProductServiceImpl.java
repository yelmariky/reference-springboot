package fr.bnpparibas.prevoyance.poc.reference.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.bnpparibas.prevoyance.poc.reference.apierrors.EntityNotFoundException;
import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;
import fr.bnpparibas.prevoyance.poc.reference.mappers.ProductMapper;
import fr.bnpparibas.prevoyance.poc.reference.model.ProductDTO;
import fr.bnpparibas.prevoyance.poc.reference.repositories.ProductRespository;
import fr.bnpparibas.prevoyance.poc.reference.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRespository productRespository;
    private final ProductMapper productMapper;
	
	public ProductServiceImpl(ProductRespository productRespository, ProductMapper productMapper) {
		this.productRespository = productRespository;
		this.productMapper = productMapper;
	}


	public List<ProductEntity> findAll() {
		return productRespository.findAll();
	}
	@Override
	public ProductDTO getProductById(Long id) throws EntityNotFoundException {
		
		Optional<ProductEntity> productEntity= productRespository.findById(id);
		if(productEntity.isPresent()) {
			return productMapper.toProductDTO(productEntity.get());
		}else {
			throw new EntityNotFoundException(ProductDTO.class,"id", String.valueOf(id));
		}
	}
	
	@Override
	public ProductDTO saveProduct(ProductEntity product) {
		return productMapper.toProductDTO(productRespository.save(product));
	}
	
	@Override
	public ProductDTO updateProduct(Long id,ProductDTO product) throws EntityNotFoundException {
		
		Optional<ProductEntity> productEntity= productRespository.findById(id);
		if(productEntity.isPresent()) {
			productEntity=Optional.of(productMapper.toProduct(product));
			ProductEntity productEntityToUpdate = productEntity.get();
			productEntityToUpdate.setId(id);
			productRespository.save(productEntityToUpdate);
			return product;
		}else {
			throw new EntityNotFoundException(ProductDTO.class,"id", String.valueOf(id));
		}
		
	}
	
	@Override
	public void deleteProductById(Long id) {
		productRespository.deleteById(id);
	}
}
