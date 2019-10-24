package puc.pos.schoolsupply.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.pos.schoolsupply.model.Shop;
import puc.pos.schoolsupply.repository.contract.IShopRepository;
import puc.pos.schoolsupply.service.contract.IShopService;

import java.util.List;

@Service
public class ShopService implements IShopService {

    private final IShopRepository shopRepository;

    @Autowired
    public ShopService(IShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop findById(int id) {
       return shopRepository.findById(id);
    }

    public Shop findByName(String name) {
        return shopRepository.findByName(name);
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
}
