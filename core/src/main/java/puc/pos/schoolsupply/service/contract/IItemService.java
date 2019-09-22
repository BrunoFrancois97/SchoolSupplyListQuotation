package puc.pos.schoolsupply.service.contract;

import puc.pos.schoolsupply.model.Item;

import java.util.List;

public interface IItemService {
     Item findById(int id);
     Item findByName(String name);
     List<Item> findAll();
}
