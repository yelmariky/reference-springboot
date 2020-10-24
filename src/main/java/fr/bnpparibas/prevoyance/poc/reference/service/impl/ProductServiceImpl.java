package fr.bnpparibas.prevoyance.poc.reference.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;
import fr.bnpparibas.prevoyance.poc.reference.repositories.ProductRespository;
import fr.bnpparibas.prevoyance.poc.reference.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRespository productRespository;

	public ProductServiceImpl(ProductRespository productRespository) {
		this.productRespository = productRespository;
	}

	public List<ProductEntity> findAll() {
		return productRespository.findAll();
	}

	public Optional<ProductEntity> findById(Long id) {
		return productRespository.findById(id);
	}

	public ProductEntity save(ProductEntity stock) {
		return productRespository.save(stock);
	}

	public void deleteById(Long id) {
		productRespository.deleteById(id);
	}
}
