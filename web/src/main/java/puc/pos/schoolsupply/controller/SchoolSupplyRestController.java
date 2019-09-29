package puc.pos.schoolsupply.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.repository.implementation.SupplyListRepository;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class SchoolSupplyRestController {

    @GetMapping("/supplyLists")
    public List<SupplyList> getSchoolSupply(){
        // TODO
        // Change this to use a Service instead of direct access to Repository
        SupplyListRepository supplyListRepository = new SupplyListRepository();
        return supplyListRepository.findAll();
    }

}
