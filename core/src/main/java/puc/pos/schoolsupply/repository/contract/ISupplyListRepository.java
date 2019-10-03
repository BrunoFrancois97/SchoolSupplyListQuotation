package puc.pos.schoolsupply.repository.contract;

import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;

import java.util.List;

public interface ISupplyListRepository {

    SupplyList findById(int id);
    List<SupplyList> findBySchool(School school);
    List<SupplyList> findByYear(int year);
    List<SupplyList> findByLevel(int level);
    SupplyList findBySchoolAndLevel(School school, int level);
    List<SupplyList> findBySchoolAndYear(School school, int year);
    SupplyList findBySchoolLevelAndYear(School school, int level, int year);
    List<SupplyList> findAll();
}
