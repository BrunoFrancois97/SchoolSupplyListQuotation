package puc.pos.schoolsupply.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.repository.contract.ISchoolRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SchoolRepository implements ISchoolRepository {

    private static final String JSON = "schools.json";

    private static List<School> schools;

    public SchoolRepository(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(JSON)));
        try {
            buildList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SchoolRepository(String resourceFile){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(resourceFile)));
        try {
            buildList(reader);
        } catch (IOException e) {
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

    private void buildList(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        schools = mapper.readValue(br, mapper.getTypeFactory().constructCollectionType(List.class, School.class));
        br.close();
    }

}
