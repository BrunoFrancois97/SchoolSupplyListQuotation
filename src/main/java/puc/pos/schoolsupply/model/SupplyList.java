package puc.pos.schoolsupply.model;

import java.util.ArrayList;
import java.util.List;

public class SupplyList {

    private School school;
    private int level;
    private int year;
    private List<Item> items;

    public SupplyList() {
        items = new ArrayList<>();
    }

    public SupplyList(School school, int level, int year, List<Item> items){
        this.school = school;
        this.level = level;
        this.year = year;
        this.items = items;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
