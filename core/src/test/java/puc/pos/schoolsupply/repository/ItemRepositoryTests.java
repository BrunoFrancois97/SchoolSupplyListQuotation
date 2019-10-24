package puc.pos.schoolsupply.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import puc.pos.schoolsupply.repository.contract.IItemRepository;
import puc.pos.schoolsupply.repository.implementation.ItemRepository;

public class ItemRepositoryTests {

    private static IItemRepository itemRepository;

    @BeforeAll
    public static void setUpBeforeTests(){
        itemRepository = new ItemRepository("items_test.json");
    }

    @Test
    public void testItemRepoCreatedSuccessfully(){
        Assertions.assertNotNull(itemRepository.findAll());
        Assertions.assertTrue(itemRepository.findAll().size() > 0);
    }

    @Test
    public void testTotalItemSize(){
        Assertions.assertEquals(8, itemRepository.findAll().size());
    }

}
