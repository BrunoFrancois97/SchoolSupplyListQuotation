package puc.pos.schoolsupply.model.dto;

import puc.pos.schoolsupply.model.dto.util.LevelDto;
import puc.pos.schoolsupply.model.dto.util.QuotationProductDto;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;

public class QuotationDto {

    private String shop;
    private String schoolName;
    private LevelDto level;
    private List<QuotationProductDto> products;
    private double totalPrice;

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public LevelDto getLevel() {
        return level;
    }

    public void setLevel(LevelDto level) {
        this.level = level;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        NumberFormat decimalFormat = new DecimalFormat("#.##", symbols);
        totalPrice = Double.parseDouble(decimalFormat.format(totalPrice));
        this.totalPrice = totalPrice;
    }

    public List<QuotationProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<QuotationProductDto> products) {
        this.products = products;
    }
}
