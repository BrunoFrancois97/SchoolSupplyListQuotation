package puc.pos.schoolsupply.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import puc.pos.schoolsupply.repository.contract.IShopRepository;
import puc.pos.schoolsupply.repository.implementation.ShopRepository;

public class ShopRepositoryTests {

    private static IShopRepository shopRepository;

    @BeforeAll
    public static void setUpBeforeTests(){
        shopRepository = new ShopRepository("shops_test.json");
    }

    @Test
    public void testShopRepoCreatedSuccessfully(){
        Assertions.assertNotNull(shopRepository.findAll());
        Assertions.assertTrue(shopRepository.findAll().size() > 0);
    }

    @Test
    public void testTotalShopsSize(){
        Assertions.assertEquals(3, shopRepository.findAll().size());
    }

    @Test
    public void testShopProductQuantity(){
        Assertions.assertEquals(9, shopRepository.findById(0).getProducts().size());
        Assertions.assertEquals(8, shopRepository.findById(1).getProducts().size());
        Assertions.assertEquals(4, shopRepository.findById(2).getProducts().size());
    }

}
