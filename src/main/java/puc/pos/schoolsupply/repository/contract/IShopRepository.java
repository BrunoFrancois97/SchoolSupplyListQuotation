package puc.pos.schoolsupply.repository.contract;

import puc.pos.schoolsupply.model.Shop;

import java.util.List;

public interface IShopRepository {

    Shop findById(int id);
    Shop findByName(String name);
    List<Shop> findAll();
}
