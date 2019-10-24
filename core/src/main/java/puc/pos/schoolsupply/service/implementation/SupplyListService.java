package puc.pos.schoolsupply.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.repository.contract.ISupplyListRepository;
import puc.pos.schoolsupply.service.contract.ISupplyListService;

import java.util.List;

@Service
public class SupplyListService implements ISupplyListService {

    private ISupplyListRepository supplyListRepository;

    @Autowired
    public SupplyListService(ISupplyListRepository supplyListRepository){
        this.supplyListRepository = supplyListRepository;
    }

    @Override
    public SupplyList findById(int id) {
        return supplyListRepository.findById(id);
    }

    @Override
    public SupplyList findBySchoolLevelAndYear(School school, int level, int year) {
        return supplyListRepository.findBySchoolLevelAndYear(school, level, year);
    }

    @Override
    public List<SupplyList> findAll() {
        return supplyListRepository.findAll();
    }
}
