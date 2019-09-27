package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.repository.contract.ISchoolRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SchoolRepository implements ISchoolRepository {

    private static final String SCHOOLS_JSON = ResourcesManipulator.getResourcePath("schools.json");

    private static List<School> schools;

    public SchoolRepository(){
        schools = new ArrayList<>();
        Gson gson = new Gson();
        try{
            Reader reader = new FileReader(SCHOOLS_JSON);
            schools = gson.fromJson(reader, new TypeToken<ArrayList<School>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public School findById(int id) {
        return schools.get(id);
    }

    public School findByName(String name) {
        for(School school : schools){
            if(school.getName().equals(name)) return school;
        }
        return null;
    }

    public List<School> findAll() {
        return schools;
    }

}