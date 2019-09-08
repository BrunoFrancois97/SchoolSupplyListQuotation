package service.implementation;

import puc.pos.schoolsupply.model.*;
import service.contract.IQuotationService;
import service.contract.IShopService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuotationService implements IQuotationService {

    private final IShopService shopService;

    public QuotationService(IShopService shopService) {
        this.shopService = shopService;
    }

    public Quotation makeQuotation(SupplyList supplyList) {
        Quotation quotation = new Quotation();
        quotation.setQuotedBy("Tester");
        Shop shop = shopService.findById("");
        quotation.setTotalPrice(calculateTotalPrice(enrichProduct(shop.getProducts(), supplyList.getItems())));
        return quotation;
    }

    private List<RichProduct> enrichProduct(List<Product>products, List<Item> items){
        List<RichProduct> richProducts = new ArrayList<RichProduct>();
        products.stream().forEach( p -> {
                    Item item = items.stream().filter(i -> i.getDescription().equals(p.getDescription())).findAny().orElse(new Item());
                    richProducts.add(createRichProduct(p.getPrice(), item.getQuantity()));
                }
        );
        return richProducts;
    }

    private RichProduct createRichProduct(double price, int quantity) {
        RichProduct richProduct = new RichProduct();
        richProduct.setPrice(price);
        richProduct.setQuantity(quantity);
        return richProduct;
    }
    
    private double calculateTotalPrice(List<RichProduct> richProducts) {
        double totalPrice = 0;

        for (RichProduct richProduct: richProducts) {
            totalPrice += richProduct.getPrice() * richProduct.getQuantity();
        }
        
        return totalPrice;
    }
}
