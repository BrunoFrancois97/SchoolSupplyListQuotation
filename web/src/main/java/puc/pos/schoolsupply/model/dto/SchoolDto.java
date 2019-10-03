package puc.pos.schoolsupply.model.dto;

import java.util.List;

public class SchoolDto {

    private String school;
    private List<LevelDto> levels;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<LevelDto> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDto> levels) {
        this.levels = levels;
    }
}
