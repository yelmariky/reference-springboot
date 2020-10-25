package fr.bnpparibas.prevoyance.poc.reference.controller;

import java.util.List;

import javax.validation.Valid;

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

import fr.bnpparibas.prevoyance.poc.reference.apierrors.EntityNotFoundException;
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
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody @Valid ProductDTO productDTO) {
		productService.saveProduct(productMapper.toProduct(productDTO));

		return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws EntityNotFoundException {
		
		return ResponseEntity.ok(productService.getProductById(id));
	
		}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO) throws EntityNotFoundException{

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.updateProduct(id, productDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id);

		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
