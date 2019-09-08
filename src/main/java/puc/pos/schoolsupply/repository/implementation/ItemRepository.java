package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.Item;
import puc.pos.schoolsupply.repository.contract.IItemRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class ItemRepository implements IItemRepository {

    private final String ITEMS_JSON;

    private static List<Item> items;

    public ItemRepository(){
        ITEMS_JSON = getResourcePath("items.json");
        Gson gson = new Gson();
        try{
            Reader reader = new FileReader(ITEMS_JSON);
            items = gson.fromJson(reader, new TypeToken<ArrayList<Item>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Item findById(int id) {
        for(Item i : items){
            if(i.getId() == id) return i;
        }
        return null;
    }

    public Item findByName(String name) {
        for(Item item : items){
            if(item.getDescription().equals(name)){
                return item;
            }
        }
        return null;
    }

    public List<Item> findAll() {
        return items;
    }

    private String getResourcePath(String fileName){
        String s = this.getClass().getClassLoader().getResource("").toString() + fileName;
        s = s.replace("file:/", "");
        return s;
    }
}
