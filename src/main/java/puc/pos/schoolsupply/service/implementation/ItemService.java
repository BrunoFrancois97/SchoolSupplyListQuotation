package puc.pos.schoolsupply.service.implementation;

import puc.pos.schoolsupply.model.Item;
import puc.pos.schoolsupply.repository.contract.IItemRepository;
import puc.pos.schoolsupply.service.contract.IItemService;

import java.util.List;

public class ItemService implements IItemService {

    private IItemRepository itemRepository;

    public ItemService(IItemRepository iItemRepository){
        this.itemRepository = iItemRepository;
    }

    public Item findById(int id) {
        return itemRepository.findById(id);
    }

    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
