package puc.pos.schoolsupply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import puc.pos.schoolsupply.facade.contract.IQuotatorFacade;
import puc.pos.schoolsupply.facade.contract.ISchoolFacade;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.model.dto.QuotationDto;
import puc.pos.schoolsupply.model.dto.SchoolDto;
import puc.pos.schoolsupply.model.dto.request.QuotatorRequestDto;
import puc.pos.schoolsupply.repository.implementation.SupplyListRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuotatorController {

    private ISchoolFacade schoolFacade;
    private IQuotatorFacade quotatorFacade;

    @Autowired
    public QuotatorController(ISchoolFacade schoolFacade, IQuotatorFacade quotatorFacade){
        this.schoolFacade = schoolFacade;
        this.quotatorFacade = quotatorFacade;
    }

    @GetMapping("/supplyLists")
    public List<SupplyList> getSchoolSupply(){
        SupplyListRepository supplyListRepository = new SupplyListRepository();
        return supplyListRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/schools")
    public List<SchoolDto> getSchoolsAndLevels(){
        return schoolFacade.findAll();
    }

    @PostMapping("/quotation")
    public QuotationDto getQuotation(@RequestBody QuotatorRequestDto requestDto){
        return quotatorFacade.makeQuotationDto(requestDto);
    }

}
