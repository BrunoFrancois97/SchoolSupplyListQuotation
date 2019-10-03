package puc.pos.schoolsupply.service.contract;

import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.dto.QuotatorDto;

public interface IQuotatorService {

    Quotation findQuotation(QuotatorDto quotatorDto);
}
