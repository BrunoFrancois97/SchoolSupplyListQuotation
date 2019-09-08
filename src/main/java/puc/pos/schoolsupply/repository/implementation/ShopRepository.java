package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.Shop;
import puc.pos.schoolsupply.repository.contract.IShopRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ShopRepository implements IShopRepository {

    private final String SHOPS_JSON;

    private static List<Shop> shops;

    public ShopRepository(){

        SHOPS_JSON = getResourcePath("shops.json");
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

    private String getResourcePath(String fileName){
        String s = this.getClass().getClassLoader().getResource("").toString() + fileName;
        s = s.replace("file:/", "");
        return s;
    }

    private class ShopJSON{
        private String name;
        private List<Integer> products;
    }

}
