package fr.bnpparibas.prevoyance.poc.reference;

import java.math.BigDecimal;

import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;

public abstract class DBUnit {

	public static ProductEntity createProduct() {
		ProductEntity product = new ProductEntity();
		product.setName("produit 1");
		product.setPrice(10);
		product.setDescription("description produit 1");

		return product;

	}
}
