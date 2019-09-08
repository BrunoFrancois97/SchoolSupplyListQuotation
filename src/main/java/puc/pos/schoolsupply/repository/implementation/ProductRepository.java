package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.Product;
import puc.pos.schoolsupply.repository.contract.IProductRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository implements IProductRepository {

    private final String PRODUCTS_JSON;

    private static List<Product> products;

    public ProductRepository(){
        PRODUCTS_JSON = getResourcePath("products.json");
        Gson gson = new Gson();
        try{
            Reader reader = new FileReader(PRODUCTS_JSON);
            products = gson.fromJson(reader, new TypeToken<ArrayList<Product>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Product findById(int id) {
        for(Product p : products){
            if(p.getId() == id) return p;
        }
        return null;
    }

    public Product findByName(String name) {
        for(Product product : products){
            if(product.getDescription().equals(name)){
                return product;
            }
        }
        return null;
    }

    public List<Product> findAll() {
        return products;
    }

    private String getResourcePath(String fileName){
        String s = this.getClass().getClassLoader().getResource("").toString() + fileName;
        s = s.replace("file:/", "");
        return s;
    }

}
