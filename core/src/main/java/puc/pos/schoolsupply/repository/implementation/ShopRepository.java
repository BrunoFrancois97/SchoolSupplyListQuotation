package puc.pos.schoolsupply.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import puc.pos.schoolsupply.model.Shop;
import puc.pos.schoolsupply.repository.contract.IProductRepository;
import puc.pos.schoolsupply.repository.contract.IShopRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShopRepository implements IShopRepository {

    private static final String JSON = "shops.json";

    private static List<Shop> shops;

    public ShopRepository(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(JSON)));
        try {
            buildList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ShopRepository(String resourceFile){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(resourceFile)));
        try {
            buildList(reader);
        } catch (IOException e) {
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

    private void buildList(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<ShopJSON> shopsJSON = mapper.readValue(br, mapper.getTypeFactory().constructCollectionType(List.class, ShopJSON.class));
        br.close();
        shops = new ArrayList<Shop>();
        IProductRepository prod = new ProductRepository();
        for(ShopJSON shopJSON : shopsJSON){
            Shop shop = new Shop();
            for(Integer i : shopJSON.products){
                if(prod.findById(i) != null) shop.getProducts().add(prod.findById(i));
            }
            shop.setName(shopJSON.name);
            shops.add(shop);
        }
    }

    private static class ShopJSON{
        public String name;
        public List<Integer> products;
    }

}
