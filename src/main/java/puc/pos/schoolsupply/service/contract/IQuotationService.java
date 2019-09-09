package puc.pos.schoolsupply.service.contract;

import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.SupplyList;

public interface IQuotationService {
    public Quotation makeQuotation(SupplyList supplyList);
}
