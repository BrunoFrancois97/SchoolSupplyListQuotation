package puc.pos.schoolsupply.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!Shop.class.isAssignableFrom(obj.getClass())) return false;

        final Shop other = (Shop) obj;
        if(!Objects.equals(this.name, other.name)) return false;

        return true;
    }

}
