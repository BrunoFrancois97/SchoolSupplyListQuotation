package puc.pos.schoolsupply.model;

public class Product {

    private double price;

    private String description;

    public Product() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
