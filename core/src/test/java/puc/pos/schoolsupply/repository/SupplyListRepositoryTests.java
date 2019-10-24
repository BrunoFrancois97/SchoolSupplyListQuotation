package puc.pos.schoolsupply.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import puc.pos.schoolsupply.repository.contract.IItemRepository;
import puc.pos.schoolsupply.repository.contract.ISupplyListRepository;
import puc.pos.schoolsupply.repository.implementation.ItemRepository;
import puc.pos.schoolsupply.repository.implementation.SupplyListRepository;

public class SupplyListRepositoryTests {

    private static ISupplyListRepository supplyListRepository;
    private static IItemRepository itemRepository;

    @BeforeAll
    public static void setUpBeforeTests(){
        supplyListRepository = new SupplyListRepository();
        itemRepository = new ItemRepository();
    }

    @Test
    public void testSupplyListRepoCreatedSuccessfully(){
        Assertions.assertNotNull(supplyListRepository.findAll());
        Assertions.assertTrue(supplyListRepository.findAll().size() > 0);
    }

    @Test
    public void testSupplyListSize(){
        Assertions.assertEquals(5, supplyListRepository.findAll().size());
    }

}
