package puc.pos.schoolsupply.service.contract;

import puc.pos.schoolsupply.model.School;

import java.util.List;

public interface ISchoolService {
    School findById(int id);
    School findByName(String name);
    List<School> findAll();
}
