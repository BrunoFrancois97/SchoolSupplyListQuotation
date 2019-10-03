package puc.pos.schoolsupply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.dto.QuotatorDto;
import puc.pos.schoolsupply.service.contract.IQuotatorService;
import puc.pos.schoolsupply.service.implementation.QuotatorService;

@Controller
public class QuotationController {

    @GetMapping({"/", "/index"})
    public String index(Model model){
        model.addAttribute("name", "Lucas");
        return "index";
    }

    @PostMapping("/quotation")
    @ResponseBody
    public Quotation quotation(@RequestBody QuotatorDto quotatorDto){
        IQuotatorService quotatorService = new QuotatorService();
        return quotatorService.findQuotation(quotatorDto);
    }

}
