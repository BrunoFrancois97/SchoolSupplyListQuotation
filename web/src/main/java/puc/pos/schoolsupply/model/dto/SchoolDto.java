package puc.pos.schoolsupply.model.dto;

import puc.pos.schoolsupply.model.dto.util.LevelDto;

import java.util.List;

public class SchoolDto {

    private String schoolName;
    private List<LevelDto> levels;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchool(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<LevelDto> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDto> levels) {
        this.levels = levels;
    }
}
