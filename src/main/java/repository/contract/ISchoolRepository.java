package repository.contract;

import puc.pos.schoolsupply.model.School;

import java.util.List;

public interface ISchoolRepository {
    public School findById(String id);
    public School findByName(String name);
    public List<School> findAll();
}
