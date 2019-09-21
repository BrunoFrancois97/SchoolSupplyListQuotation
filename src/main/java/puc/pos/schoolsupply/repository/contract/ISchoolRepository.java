package puc.pos.schoolsupply.repository.contract;

import puc.pos.schoolsupply.model.School;

import java.util.List;

public interface ISchoolRepository {
    School findById(int id);
    School findByName(String name);
    List<School> findAll();
}
