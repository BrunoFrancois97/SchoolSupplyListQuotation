package puc.pos.schoolsupply.repository.contract;

import puc.pos.schoolsupply.model.Quotation;

import java.util.List;


public interface IQuotationRepository {
    Quotation findById(String id);
    Quotation findByName(String name);
    List<Quotation> findAll();
}
