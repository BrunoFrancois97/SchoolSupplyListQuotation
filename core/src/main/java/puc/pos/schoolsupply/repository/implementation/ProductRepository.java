package puc.pos.schoolsupply.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import puc.pos.schoolsupply.model.Product;
import puc.pos.schoolsupply.repository.contract.IProductRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class ProductRepository implements IProductRepository {

    private static final String JSON = "products.json";

    private static List<Product> products;

    public ProductRepository(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(JSON)));
        try {
            buildList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProductRepository(String resourceFile){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(resourceFile)));
        try {
            buildList(reader);
        } catch (IOException e) {
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

    private void buildList(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        products = mapper.readValue(br, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        br.close();
    }

}
