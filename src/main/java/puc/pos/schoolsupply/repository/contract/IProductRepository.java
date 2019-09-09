package puc.pos.schoolsupply.repository.contract;

import puc.pos.schoolsupply.model.Product;

import java.util.List;

public interface IProductRepository {
    Product findById(int id);
    Product findByName(String name);
    List<Product> findAll();
}
