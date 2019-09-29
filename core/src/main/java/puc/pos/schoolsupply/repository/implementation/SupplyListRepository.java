package puc.pos.schoolsupply.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.repository.contract.IItemRepository;
import puc.pos.schoolsupply.repository.contract.ISchoolRepository;
import puc.pos.schoolsupply.repository.contract.ISupplyListRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SupplyListRepository implements ISupplyListRepository {

    private static final String JSON = "supplyLists.json";

    private static List<SupplyList> supplyLists;

    public SupplyListRepository() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(JSON)));
        try {
            buildList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SupplyListRepository(String resourceFile){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(resourceFile)));
        try {
            buildList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SupplyList findById(int id) {
        return supplyLists.get(id);
    }

    public List<SupplyList> findBySchool(School school) {
        List<SupplyList> schoolList = new ArrayList<>();
        for(SupplyList supplyList : supplyLists){
            if(supplyList.getSchool().equals(school)){
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
            if(supplyList.getSchool().equals(school)){
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

    private void buildList(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<SupplyListJSON> supplyListJSON = mapper.readValue(br, mapper.getTypeFactory().constructCollectionType(List.class, SupplyListJSON.class));
        br.close();
        supplyLists = new ArrayList<SupplyList>();
        IItemRepository itemRep = new ItemRepository();
        ISchoolRepository schoolRep = new SchoolRepository();
        for (SupplyListJSON supplyJson : supplyListJSON) {
            SupplyList supplyList = new SupplyList();
            for (Integer i : supplyJson.items) {
                if (itemRep.findById(i) != null) supplyList.getItems().add(itemRep.findById(i));
            }
            supplyList.setSchool(schoolRep.findByName(supplyJson.school));
            supplyList.setLevel(supplyJson.level);
            supplyList.setYear(supplyJson.year);
            supplyLists.add(supplyList);
        }
    }

    private static class SupplyListJSON{
        public String school;
        public int level;
        public int year;
        public List<Integer> items;
    }

}
