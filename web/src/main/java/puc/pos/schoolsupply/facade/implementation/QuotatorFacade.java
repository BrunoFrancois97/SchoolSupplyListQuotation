package puc.pos.schoolsupply.facade.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import puc.pos.schoolsupply.facade.contract.IQuotatorFacade;
import puc.pos.schoolsupply.factory.QuotationDtoFactory;
import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.model.dto.QuotationDto;
import puc.pos.schoolsupply.model.dto.request.QuotatorRequestDto;
import puc.pos.schoolsupply.service.contract.IQuotationService;
import puc.pos.schoolsupply.service.contract.ISupplyListService;

@Component
public class QuotatorFacade implements IQuotatorFacade {

    private ISupplyListService supplyListService;
    private IQuotationService quotationService;

    @Autowired
    public QuotatorFacade(ISupplyListService supplyListService, IQuotationService quotationService){
        this.supplyListService = supplyListService;
        this.quotationService = quotationService;
    }

    public QuotationDto makeQuotationDto(QuotatorRequestDto quotatorRequestDto){
        QuotationDtoFactory factory = new QuotationDtoFactory();
        Quotation q = makeQuotation(quotatorRequestDto);

        return factory.createQuotationDto(q);
    }

    private Quotation makeQuotation(QuotatorRequestDto quotatorRequestDto){
        SupplyList s = supplyListService
                .findBySchoolLevelAndYear(new School(quotatorRequestDto.getSchoolName()), quotatorRequestDto.getLevelId(), 2019);

        return quotationService.makeQuotation(s);
    }

}
