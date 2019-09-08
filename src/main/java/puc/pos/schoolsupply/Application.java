package puc.pos.schoolsupply;

import puc.pos.schoolsupply.model.Item;
import puc.pos.schoolsupply.repository.implementation.SupplyListRepository;

import java.util.List;

public class Application {

    public static void main(String[] args){

        SupplyListRepository supplyListRepository = new SupplyListRepository();

        List<Item> items = supplyListRepository.findById(1).getItems();

        for(Item i : items){
            System.out.println(i.getDescription());
        }

    }

}
