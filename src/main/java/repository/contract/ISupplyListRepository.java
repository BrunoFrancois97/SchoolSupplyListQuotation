package repository.contract;

import puc.pos.schoolsupply.model.SupplyList;

import java.util.List;

public interface ISupplyListRepository {
    public SupplyList findById(String id);
    public SupplyList findByName(String name);
    public List<SupplyList> findAll();
}
