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
        shopRepository = new ShopRepository();
    }

    @Test
    public void testTotalShopsSize(){
        Assertions.assertEquals(3, shopRepository.findAll().size());
    }

}
