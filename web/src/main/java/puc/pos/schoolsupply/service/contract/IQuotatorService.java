package puc.pos.schoolsupply.service.contract;

import puc.pos.schoolsupply.model.dto.QuotationDto;
import puc.pos.schoolsupply.model.dto.request.QuotatorRequestDto;

public interface IQuotatorService {

    QuotationDto makeQuotationDto(QuotatorRequestDto quotatorRequestDto);
}
