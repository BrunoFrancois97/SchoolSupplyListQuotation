package service.contract;

import puc.pos.schoolsupply.model.Shop;

import java.util.List;

public interface IShopRepository {
    public Shop findById(String id);
    public Shop findByName(String name);
    public List<Shop> findAll();
}
