package service.contract;

import puc.pos.schoolsupply.model.Product;

import java.util.List;

public interface IProductRepository {
    public Product findById(String id);
    public Product findByName(String name);
    public List<Product> findAll();
}
