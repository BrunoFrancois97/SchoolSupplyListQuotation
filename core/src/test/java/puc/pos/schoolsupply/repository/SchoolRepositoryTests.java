package puc.pos.schoolsupply.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import puc.pos.schoolsupply.repository.contract.ISchoolRepository;
import puc.pos.schoolsupply.repository.implementation.SchoolRepository;

public class SchoolRepositoryTests {

    private static ISchoolRepository schoolRepository;

    @BeforeAll
    public static void setUpBeforeTests(){
        schoolRepository = new SchoolRepository("schools_test.json");
    }

    @Test
    public void testSchoolRepoCreatedSuccessfully(){
        Assertions.assertNotNull(schoolRepository.findAll());
        Assertions.assertTrue(schoolRepository.findAll().size() > 0);
    }

    @Test
    public void testTotalSchoolSize(){
        Assertions.assertEquals(3, schoolRepository.findAll().size());
    }

}
