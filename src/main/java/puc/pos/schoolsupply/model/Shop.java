package puc.pos.schoolsupply.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String name;
    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    public Shop(String name, ArrayList<Product> products){
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
