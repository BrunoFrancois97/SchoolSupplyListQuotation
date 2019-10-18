package puc.pos.schoolsupply.factory;

import puc.pos.schoolsupply.model.dto.util.LevelDto;
import puc.pos.schoolsupply.model.dto.SchoolDto;

import java.util.ArrayList;
import java.util.List;

public class SchoolDtoFactory {

    public SchoolDto createSchoolDto(String schoolName, List<Integer> levels){
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setSchool(schoolName);
        List<LevelDto> levelDtos = new ArrayList<LevelDto>();
        for(Integer i : levels){
            LevelDto levelDto = new LevelDto(i, i+"° ano");
            levelDtos.add(levelDto);
        }
        schoolDto.setLevels(levelDtos);
        return schoolDto;
    }

}
