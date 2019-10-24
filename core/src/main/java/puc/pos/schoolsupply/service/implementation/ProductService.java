package puc.pos.schoolsupply.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.pos.schoolsupply.model.Product;
import puc.pos.schoolsupply.repository.contract.IProductRepository;
import puc.pos.schoolsupply.service.contract.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
