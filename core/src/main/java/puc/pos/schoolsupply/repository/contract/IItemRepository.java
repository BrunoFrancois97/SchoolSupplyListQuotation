package puc.pos.schoolsupply.repository.contract;

import puc.pos.schoolsupply.model.Item;

import java.util.List;


public interface IItemRepository {
    Item findById(int id);
    Item findByName(String name);
    List<Item> findAll();
}
