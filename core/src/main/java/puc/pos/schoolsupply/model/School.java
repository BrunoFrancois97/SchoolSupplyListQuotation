package puc.pos.schoolsupply.model;

import java.util.List;
import java.util.Objects;

public class School {

    private String name;
    private List<Integer> levels;

    public School() {

    }

    public School(String name){
        this.name = name;
    }

    public School(String name, List<Integer> levels){
        this.name = name;
        this.levels = levels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getLevels() { return levels; }

    public void setLevels(List<Integer> levels) { this.levels = levels; }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!School.class.isAssignableFrom(obj.getClass())) return false;

        final School other = (School) obj;
        if(!Objects.equals(this.name, other.name)) return false;

        return true;
    }
}
