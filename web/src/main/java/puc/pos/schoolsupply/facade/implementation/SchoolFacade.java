package puc.pos.schoolsupply.facade.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import puc.pos.schoolsupply.facade.contract.ISchoolFacade;
import puc.pos.schoolsupply.factory.SchoolDtoFactory;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.dto.SchoolDto;
import puc.pos.schoolsupply.repository.contract.ISchoolRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class SchoolFacade implements ISchoolFacade {

    private ISchoolRepository schoolRepository;
    private SchoolDtoFactory factory;

    @Autowired
    public SchoolFacade(ISchoolRepository schoolRepository, SchoolDtoFactory factory){
        this.schoolRepository = schoolRepository;
        this.factory = factory;
    }

    public List<SchoolDto> findAll(){
        List<SchoolDto> schoolDtos = new ArrayList<SchoolDto>();
        for(School s : schoolRepository.findAll()){
            schoolDtos.add(factory.createSchoolDto(s.getName(), s.getLevels()));
        }
        return schoolDtos;
    }

}
