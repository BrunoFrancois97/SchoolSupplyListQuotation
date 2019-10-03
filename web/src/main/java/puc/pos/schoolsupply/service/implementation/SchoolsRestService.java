package puc.pos.schoolsupply.service.implementation;

import org.springframework.stereotype.Service;
import puc.pos.schoolsupply.factory.SchoolDtoFactory;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.dto.SchoolDto;
import puc.pos.schoolsupply.repository.contract.ISchoolRepository;
import puc.pos.schoolsupply.repository.implementation.SchoolRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolsRestService {

    private ISchoolRepository schoolRepository;
    private SchoolDtoFactory factory;

    public SchoolsRestService(){
        schoolRepository = new SchoolRepository();
        factory = new SchoolDtoFactory();
    }

    public List<SchoolDto> findAll(){
        List<SchoolDto> schoolDtos = new ArrayList<SchoolDto>();
        for(School s : schoolRepository.findAll()){
            schoolDtos.add(factory.createSchoolDto(s.getName(), s.getLevels()));
        }
        return schoolDtos;
    }

}
