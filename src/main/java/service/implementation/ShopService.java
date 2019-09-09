package service.implementation;

import puc.pos.schoolsupply.model.Product;
import puc.pos.schoolsupply.model.Shop;
import service.contract.IShopService;

import java.util.ArrayList;
import java.util.List;

public class ShopService implements IShopService {
    public Shop findById(String id) {
        ArrayList<Product> products = addProducts(new ArrayList<Product>());
        Shop shop = new Shop();
        shop.setName("Test Shop");
        shop.setProducts(products);
        return shop;
    }

    private ArrayList<Product> addProducts(ArrayList<Product> products)
    {
        Product p1 = new Product();
        p1.setDescription("Lapis");
        p1.setPrice(2.50);
        products.add(p1);

        Product p2 = new Product();
        p2.setDescription("Caneta");
        p2.setPrice(2.50);
        products.add(p2);

        return products;
    }

    public Shop findByName(String name) {
        return null;
    }

    public List<Shop> findAll() {
        return null;
    }
}
