package puc.pos.schoolsupply.controller;

import org.springframework.web.bind.annotation.*;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.model.dto.QuotationDto;
import puc.pos.schoolsupply.model.dto.SchoolDto;
import puc.pos.schoolsupply.model.dto.request.QuotatorRequestDto;
import puc.pos.schoolsupply.repository.implementation.SupplyListRepository;
import puc.pos.schoolsupply.service.contract.IQuotatorService;
import puc.pos.schoolsupply.service.implementation.QuotatorService;
import puc.pos.schoolsupply.service.implementation.SchoolsRestService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolSupplyRestController {

    @GetMapping("/supplyLists")
    public List<SupplyList> getSchoolSupply(){
        // TODO
        // Change this to use a Service instead of direct access to Repository
        SupplyListRepository supplyListRepository = new SupplyListRepository();
        return supplyListRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/schools")
    public List<SchoolDto> getSchoolsAndLevels(){
        SchoolsRestService service = new SchoolsRestService();
        return service.findAll();
    }

    @PostMapping("/quotation")
    public QuotationDto getQuotation(@RequestBody QuotatorRequestDto requestDto){
        IQuotatorService quotatorService = new QuotatorService();
        return quotatorService.makeQuotationDto(requestDto);
    }

}
