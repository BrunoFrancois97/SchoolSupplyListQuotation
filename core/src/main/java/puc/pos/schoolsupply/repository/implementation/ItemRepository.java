package puc.pos.schoolsupply.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import puc.pos.schoolsupply.model.Item;
import puc.pos.schoolsupply.repository.contract.IItemRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.*;
import java.util.List;


public class ItemRepository implements IItemRepository {

    private static final String JSON = "items.json";

    private static List<Item> items;

    public ItemRepository(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(JSON)));
        try {
            buildList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ItemRepository(String resourceFile){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(resourceFile)));
        try {
            buildList(reader);
        } catch (IOException e) {
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

    private void buildList(BufferedReader br) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        items = mapper.readValue(br, mapper.getTypeFactory().constructCollectionType(List.class, Item.class));
        br.close();
    }

}
