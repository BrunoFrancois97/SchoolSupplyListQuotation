package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.Product;
import puc.pos.schoolsupply.repository.contract.IProductRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository implements IProductRepository {

    private static final String PRODUCTS_JSON = ResourcesManipulator.getResourcePath("products.json");

    private static List<Product> products;

    public ProductRepository(){
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

}
