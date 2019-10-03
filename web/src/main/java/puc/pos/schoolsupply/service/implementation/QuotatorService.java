package puc.pos.schoolsupply.service.implementation;

import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.model.dto.QuotatorDto;
import puc.pos.schoolsupply.repository.contract.ISupplyListRepository;
import puc.pos.schoolsupply.repository.implementation.ShopRepository;
import puc.pos.schoolsupply.repository.implementation.SupplyListRepository;
import puc.pos.schoolsupply.service.contract.IQuotationService;
import puc.pos.schoolsupply.service.contract.IQuotatorService;

public class QuotatorService implements IQuotatorService {

    public Quotation findQuotation(QuotatorDto quotatorDto){

        ISupplyListRepository supplyListRepository = new SupplyListRepository();
        IQuotationService quotationService = new QuotationService(new ShopService(new ShopRepository()));

        SupplyList s = supplyListRepository
                .findBySchoolLevelAndYear(new School(quotatorDto.getSchool()), quotatorDto.getLevel(), 2019);
        return quotationService.makeQuotation(s);

    }

}
