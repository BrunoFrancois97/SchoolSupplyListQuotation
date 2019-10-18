package puc.pos.schoolsupply.service.implementation;

import puc.pos.schoolsupply.factory.QuotationDtoFactory;
import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.model.dto.QuotationDto;
import puc.pos.schoolsupply.model.dto.request.QuotatorRequestDto;
import puc.pos.schoolsupply.repository.contract.ISupplyListRepository;
import puc.pos.schoolsupply.repository.implementation.ShopRepository;
import puc.pos.schoolsupply.repository.implementation.SupplyListRepository;
import puc.pos.schoolsupply.service.contract.IQuotationService;
import puc.pos.schoolsupply.service.contract.IQuotatorService;

public class QuotatorService implements IQuotatorService {

    public QuotationDto makeQuotationDto(QuotatorRequestDto quotatorRequestDto){

        QuotationDtoFactory factory = new QuotationDtoFactory();
        Quotation q = makeQuotation(quotatorRequestDto);

        return factory.createQuotationDto(q);
    }

    private Quotation makeQuotation(QuotatorRequestDto quotatorRequestDto){

        ISupplyListRepository supplyListRepository = new SupplyListRepository();
        IQuotationService quotationService = new QuotationService(new ShopService(new ShopRepository()));

        SupplyList s = supplyListRepository
                .findBySchoolLevelAndYear(new School(quotatorRequestDto.getSchoolName()), quotatorRequestDto.getLevelId(), 2019);

        return quotationService.makeQuotation(s);

    }

}
