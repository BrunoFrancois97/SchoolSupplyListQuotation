package repository.contract;

import puc.pos.schoolsupply.model.Item;

import java.util.List;


public interface IItemRepository {
    public Item findById(String id);
    public Item findByName(String name);
    public List<Item> findAll();
}
