package fr.bnpparibas.prevoyance.poc.reference.controller;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;
import fr.bnpparibas.prevoyance.poc.reference.mappers.ProductMapper;
import fr.bnpparibas.prevoyance.poc.reference.model.ProductDTO;
import fr.bnpparibas.prevoyance.poc.reference.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	private final ProductService productService;

	private final ProductMapper productMapper;
	
	public ProductController(ProductService productService, ProductMapper productMapper) {
		this.productService = productService;
		this.productMapper = productMapper;
	}


	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		return ResponseEntity.ok(productMapper.toProductDTOs(productService.findAll()));
	}

	@PostMapping
	public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
		productService.save(productMapper.toProduct(productDTO));

		return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		Optional<ProductEntity> product = productService.findById(id);

		return ResponseEntity.ok(productMapper.toProductDTO(product.get()));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		ProductEntity product = productMapper.toProduct(productDTO);
		product.setId(id);

		productService.save(product);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		productService.deleteById(id);

		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
