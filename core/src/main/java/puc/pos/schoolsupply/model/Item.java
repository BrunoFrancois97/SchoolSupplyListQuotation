package puc.pos.schoolsupply.model;

public class Item {

    private int quantity;
    private String description;
    private int id;

    private static int counter;

    public Item() {

    }

    public Item(String description, int quantity){
        this.description = description;
        this.quantity = quantity;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){ this.id = id; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
