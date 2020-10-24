package fr.bnpparibas.prevoyance.poc.reference.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static fr.bnpparibas.prevoyance.poc.reference.DBUnit.createProduct;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRespository productRepository;

    @Test
    public void canSaveProduct() {
    	productRepository.save(createProduct());
    }

}