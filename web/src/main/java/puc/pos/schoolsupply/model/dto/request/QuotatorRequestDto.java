package puc.pos.schoolsupply.model.dto.request;

public class QuotatorRequestDto {

    private String schoolName;
    private int levelId;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}
