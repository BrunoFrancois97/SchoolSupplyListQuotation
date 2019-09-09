package puc.pos.schoolsupply.service.contract;

import puc.pos.schoolsupply.model.Shop;

import java.util.List;

public interface IShopService {
    public Shop findById(String id);
    public Shop findByName(String name);
    public List<Shop> findAll();
}
