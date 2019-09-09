package repository.contract;

import puc.pos.schoolsupply.model.Quotation;

import java.util.List;


public interface IQuotationRepository {
    public Quotation findById(String id);
    public Quotation findByName(String name);
    public List<Quotation> findAll();
}
