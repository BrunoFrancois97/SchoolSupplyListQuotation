package puc.pos.schoolsupply.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!SupplyList.class.isAssignableFrom(obj.getClass())) return false;

        final SupplyList other = (SupplyList) obj;
        if(!Objects.equals(this.school, other.school)) return false;
        if(this.level != other.level) return false;
        if(this.year != other.year) return false;

        return true;
    }

}
