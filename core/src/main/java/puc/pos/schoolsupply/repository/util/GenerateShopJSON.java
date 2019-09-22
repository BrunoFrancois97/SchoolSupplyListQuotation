package puc.pos.schoolsupply.repository.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import puc.pos.schoolsupply.model.Product;
import puc.pos.schoolsupply.model.Shop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateShopJSON {

    private ArrayList<Shop> shops;

    public GenerateShopJSON(){
        shops = new ArrayList<Shop>();
        shops.add(createShop("Papelaria A"));
        shops.add(createShop("Papelaria B"));
    }

    public void createJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter;
        try {
            String path = this.getClass().getClassLoader().getResource("").toString();
            System.out.println(path);
            path = path.replace("file:/", "");
            fileWriter = new FileWriter(path + "shops.json");
            fileWriter.write(gson.toJson(shops));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Shop createShop(String name){

        Shop shop = new Shop();
        shop.setName(name);
        shop.setProducts(new ArrayList<Product>(Arrays.asList(
                new Product("Caderno 200 folhas", 15.00),
                new Product("Caneta azul", 4.50),
                new Product("Borracha branca", 3.20),
                new Product("Cola branca", 5.00),
                new Product("Cartolina", 5.20))));

        return shop;

    }

}
