package fr.bnpparibas.prevoyance.poc.reference.model;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private String description;
    private int price;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    
}
