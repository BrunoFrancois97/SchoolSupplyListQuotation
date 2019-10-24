package puc.pos.schoolsupply.service.contract;

import puc.pos.schoolsupply.model.Product;

import java.util.List;

public interface IProductService {
    Product findById(int id);
    Product findByName(String name);
    List<Product> findAll();
}
