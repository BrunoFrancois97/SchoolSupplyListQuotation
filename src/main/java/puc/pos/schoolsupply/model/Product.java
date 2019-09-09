package puc.pos.schoolsupply.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class Product {

    private double price;
    private String description;
    private int id;

    public Product() {

    }

    public Product(String description, double price){
        this.description = description;
        setPrice(price);
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
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
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        NumberFormat decimalFormat = new DecimalFormat("#.##", symbols);
        price = Double.parseDouble(decimalFormat.format(price));
        this.price = price;
    }
}
