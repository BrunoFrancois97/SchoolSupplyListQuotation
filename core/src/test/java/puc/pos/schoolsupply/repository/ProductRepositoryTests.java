package puc.pos.schoolsupply.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import puc.pos.schoolsupply.repository.contract.IProductRepository;
import puc.pos.schoolsupply.repository.implementation.ProductRepository;

public class ProductRepositoryTests {

    private static IProductRepository productRepository;

    @BeforeAll
    public static void setUpBeforeTests(){
        productRepository = new ProductRepository("products_test.json");
    }

    @Test
    public void testProductRepoCreatedSuccessfully(){
        Assertions.assertNotNull(productRepository.findAll());
        Assertions.assertTrue(productRepository.findAll().size() > 0);
    }

    @Test
    public void testTotalProductSize(){
        Assertions.assertEquals(9, productRepository.findAll().size());
    }

}
