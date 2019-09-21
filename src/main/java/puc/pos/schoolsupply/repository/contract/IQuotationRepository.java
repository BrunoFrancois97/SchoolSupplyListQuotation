package puc.pos.schoolsupply.repository.contract;

import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.SupplyList;

import java.util.List;


public interface IQuotationRepository {
    Quotation findById(int id);
    Quotation findBySupplyList(SupplyList supplyList);
    List<Quotation> findAll();
}
