package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.repository.contract.ISupplyListRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SupplyListRepository implements ISupplyListRepository {

    private final String SUPPLYLIST_JSON;

    private static List<SupplyList> supplyLists;

    public SupplyListRepository() {

        SUPPLYLIST_JSON = getResourcePath("supplyLists.json");
        Gson gson = new Gson();
        supplyLists = new ArrayList<>();
        try{
            Reader reader = new FileReader(SUPPLYLIST_JSON);
            List<SupplyListJSON> supplyListJSON = gson.fromJson(reader, new TypeToken<ArrayList<SupplyListJSON>>(){}.getType());
            ItemRepository itemRep = new ItemRepository();
            SchoolRepository schoolRep = new SchoolRepository();
            for(SupplyListJSON supplyJson : supplyListJSON){
                SupplyList supplyList = new SupplyList();
                for(String s : supplyJson.items){
                    if(itemRep.findByName(s) != null){
                        supplyList.getItems().add(itemRep.findByName(s));
                    }
                }
                supplyList.setSchool(schoolRep.findByName(supplyJson.school));
                supplyList.setLevel(supplyJson.level);
                supplyList.setYear(supplyJson.year);
                supplyLists.add(supplyList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public SupplyList findById(int id) {
        return supplyLists.get(id);
    }

    public List<SupplyList> findBySchool(School school) {
        List<SupplyList> schoolList = new ArrayList<>();
        for(SupplyList supplyList : supplyLists){
            if(supplyList.getSchool().getName().equals(school.getName())){
                schoolList.add(supplyList);
            }
        }
        return schoolList;
    }

    // TODO
    public List<SupplyList> findByYear(int year) {
        return null;
    }

    // TODO
    public List<SupplyList> findByLevel(int level) {
        return null;
    }

    // TODO
    public List<SupplyList> findBySchoolAndLevel(School school, int level) {
        return null;
    }

    // TODO
    public List<SupplyList> findBySchoolAndYear(School school, int year) {
        return null;
    }

    public SupplyList findBySchoolLevelAndYear(School school, int level, int year) {
        for(SupplyList supplyList : supplyLists){
            if(supplyList.getSchool().getName().equals(school.getName())){
                if(supplyList.getLevel() == level){
                    if(supplyList.getYear() == year){
                        return supplyList;
                    }
                }
            }
        }
        return null;
    }

    public List<SupplyList> findAll() {
        return supplyLists;
    }

    private String getResourcePath(String fileName){
        String s = this.getClass().getClassLoader().getResource("").toString() + fileName;
        s = s.replace("file:/", "");
        return s;
    }

    private class SupplyListJSON{
        private String school;
        private int level;
        private int year;
        private List<String> items;
    }

}
