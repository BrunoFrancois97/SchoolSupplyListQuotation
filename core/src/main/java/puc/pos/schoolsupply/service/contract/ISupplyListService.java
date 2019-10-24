package puc.pos.schoolsupply.service.contract;

import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;

import java.util.List;

public interface ISupplyListService {
    SupplyList findById(int id);
    SupplyList findBySchoolLevelAndYear(School school, int level, int year);
    List<SupplyList> findAll();
}
