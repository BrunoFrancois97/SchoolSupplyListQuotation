package puc.pos.schoolsupply.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import puc.pos.schoolsupply.repository.implementation.ItemRepository;

public class ItemRepositoryTests {

    @Test
    public void testDefaultAndTestReposHaveDiffSize(){
        int defaultRepoSize = new ItemRepository().findAll().size();
        int testRepoSize = new ItemRepository("items_test.json").findAll().size();
        Assertions.assertEquals(8, defaultRepoSize);
        Assertions.assertEquals(7, testRepoSize);
        Assertions.assertNotEquals(defaultRepoSize, testRepoSize);
    }

}
