package fr.bnpparibas.prevoyance.poc.reference.service;

import java.util.List;
import java.util.Optional;

import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;

public interface ProductService {
	 public List<ProductEntity> findAll() ;

	    public Optional<ProductEntity> findById(Long id) ;

	    public ProductEntity save(ProductEntity stock) ;

	    public void deleteById(Long id);

}
