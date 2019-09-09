package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.Item;
import puc.pos.schoolsupply.repository.contract.IItemRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class ItemRepository implements IItemRepository {

    private static final String ITEMS_JSON = ResourcesManipulator.getResourcePath("items.json");

    private static List<Item> items;

    public ItemRepository(){
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

}
