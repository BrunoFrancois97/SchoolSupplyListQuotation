package puc.pos.schoolsupply.model;

public class Quotation {

    private String quotedBy;
    private double totalPrice;
    private SupplyList supplyList;
    private Shop shop;

    public Quotation(){

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
}
