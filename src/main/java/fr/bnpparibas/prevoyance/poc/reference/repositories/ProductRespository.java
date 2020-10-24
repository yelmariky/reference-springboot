package fr.bnpparibas.prevoyance.poc.reference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bnpparibas.prevoyance.poc.reference.entities.ProductEntity;

public interface ProductRespository extends JpaRepository<ProductEntity, Long> {
}
