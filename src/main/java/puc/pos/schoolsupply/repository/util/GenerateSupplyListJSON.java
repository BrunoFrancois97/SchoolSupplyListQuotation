package puc.pos.schoolsupply.repository.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import puc.pos.schoolsupply.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GenerateSupplyListJSON {

    private ArrayList<SupplyList> supplyLists;

    public GenerateSupplyListJSON(){
        School aSchool = new School("Escola A");
        supplyLists = new ArrayList<SupplyList>();
        supplyLists.add(createSupplyList(aSchool));
        supplyLists.add(createSupplyList(aSchool));
        supplyLists.add(createSupplyList(aSchool));
        supplyLists.add(createSupplyList(new School("Escola B")));
        supplyLists.add(createSupplyList(new School("Escola C")));
    }

    public void createJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter;
        try {
            String path = this.getClass().getClassLoader().getResource("").toString();
            System.out.println(path);
            path = path.replace("file:/", "");
            fileWriter = new FileWriter(path + "supplyLists2.json");
            fileWriter.write(gson.toJson(supplyLists));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SupplyList createSupplyList(School school){

        SupplyList supplyList = new SupplyList();
        supplyList.setSchool(school);
        supplyList.setLevel(new Random().nextInt(10) + 1);
        supplyList.setYear(new Random().nextInt(10) + 2010);
        supplyList.setItems(new ArrayList<Item>(Arrays.asList(
                new Item("Caneta azul", 2),
                new Item("Apontador", 1),
                new Item("Lapis preto", 1),
                new Item("Cola branca", 1),
                new Item("Caderno 200 folhas", 1)
        )));

        return supplyList;

    }

}
