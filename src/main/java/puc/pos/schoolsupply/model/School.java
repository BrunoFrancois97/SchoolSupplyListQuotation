package puc.pos.schoolsupply.model;

import java.util.Objects;

public class School {

    private String name;

    public School() {

    }

    public School(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!School.class.isAssignableFrom(obj.getClass())) return false;

        final School other = (School) obj;
        if(!Objects.equals(this.name, other.name)) return false;

        return true;
    }
}
