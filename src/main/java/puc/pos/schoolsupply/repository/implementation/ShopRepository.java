package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.Shop;
import puc.pos.schoolsupply.repository.contract.IShopRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ShopRepository implements IShopRepository {

    private static final String SHOPS_JSON = ResourcesManipulator.getResourcePath("shops.json");;

    private static List<Shop> shops;

    public ShopRepository(){
        Gson gson = new Gson();
        shops = new ArrayList<>();
        try{
            Reader reader = new FileReader(SHOPS_JSON);
            List<ShopJSON> shopsJSON = gson.fromJson(reader, new TypeToken<ArrayList<ShopJSON>>(){}.getType());
            ProductRepository prod = new ProductRepository();
            for(ShopJSON shopJSON : shopsJSON){
                Shop shop = new Shop();
                for(Integer i : shopJSON.products){
                    if(prod.findById(i) != null) shop.getProducts().add(prod.findById(i));
                }
                shop.setName(shopJSON.name);
                shops.add(shop);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Shop findById(int id) {
        return shops.get(id);
    }

    public Shop findByName(String name) {
        for(Shop shop : shops){
            if(shop.getName().equals(name)){
                return shop;
            }
        }
        return null;
    }

    public List<Shop> findAll() {
        return shops;
    }

    private static class ShopJSON{
        private String name;
        private List<Integer> products;
    }

}
