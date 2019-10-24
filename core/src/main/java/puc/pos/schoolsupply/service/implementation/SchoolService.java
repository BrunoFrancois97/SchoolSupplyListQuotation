package puc.pos.schoolsupply.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.repository.contract.ISchoolRepository;
import puc.pos.schoolsupply.service.contract.ISchoolService;

import java.util.List;

@Service
public class SchoolService implements ISchoolService {

    private ISchoolRepository schoolRepository;

    @Autowired
    public SchoolService(ISchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School findById(int id) {
        return schoolRepository.findById(id);
    }

    @Override
    public School findByName(String name) {
        return schoolRepository.findByName(name);
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }
}
