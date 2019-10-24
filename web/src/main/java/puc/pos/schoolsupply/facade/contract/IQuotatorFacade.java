package puc.pos.schoolsupply.facade.contract;

import puc.pos.schoolsupply.model.dto.QuotationDto;
import puc.pos.schoolsupply.model.dto.request.QuotatorRequestDto;

public interface IQuotatorFacade {
    QuotationDto makeQuotationDto(QuotatorRequestDto quotatorRequestDto);
}
