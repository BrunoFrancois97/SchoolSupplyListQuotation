package puc.pos.schoolsupply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuotationController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("name", "Lucas");
        return "index";
    }

}
