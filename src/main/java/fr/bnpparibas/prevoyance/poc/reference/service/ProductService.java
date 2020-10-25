package fr.bnpparibas.prevoyance.poc.reference.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.bnpparibas.prevoyance.poc.reference.apierrors.EntityNotFoundException;
import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;
import fr.bnpparibas.prevoyance.poc.reference.model.ProductDTO;

public interface ProductService {
	    public List<ProductEntity> findAll() ;

	    public ProductDTO getProductById(Long id) throws EntityNotFoundException ;

	    public ProductDTO saveProduct(ProductEntity stock) ;

	    public void deleteProductById(Long id);
	    
	    public ProductDTO updateProduct(Long id, ProductDTO productDTO) throws EntityNotFoundException;

}
