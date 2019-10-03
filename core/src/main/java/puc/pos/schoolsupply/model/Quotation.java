package puc.pos.schoolsupply.model;

import java.util.List;

public class Quotation {

    private String quotedBy;
    private double totalPrice;
    private SupplyList supplyList;
    private Shop shop;
    private List<Item> items;

    public Quotation(){

    }

    public Quotation(String quotedBy, double totalPrice, SupplyList supplyList, Shop shop, List<Item> items){
        this.quotedBy = quotedBy;
        this.totalPrice = totalPrice;
        this.supplyList = supplyList;
        this.shop = shop;
        this.items = items;
    }

    public String getQuotedBy() {
        return quotedBy;
    }

    public void setQuotedBy(String quotedBy) {
        this.quotedBy = quotedBy;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public SupplyList getSupplyList() {
        return supplyList;
    }

    public void setSupplyList(SupplyList supplyList) {
        this.supplyList = supplyList;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
