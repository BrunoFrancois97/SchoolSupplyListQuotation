package puc.pos.schoolsupply.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.repository.contract.IQuotationRepository;
import puc.pos.schoolsupply.repository.contract.IShopRepository;
import puc.pos.schoolsupply.repository.contract.ISupplyListRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class QuotationRepository implements IQuotationRepository {

    private static final String JSON = "quotations.json";

    private static List<Quotation> quotationList;

    public QuotationRepository(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(JSON)));
        try {
            buildList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QuotationRepository(String resourceFile){
        BufferedReader reader = new BufferedReader(new InputStreamReader(ResourcesManipulator.getResourceStream(resourceFile)));
        try {
            buildList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Quotation findById(int id) {
        return quotationList.get(id);
    }

    public Quotation findBySupplyList(SupplyList supplyList) {
        for(Quotation i : quotationList){
            if(i.getSupplyList().equals(supplyList)) return i;
        }
        return null;
    }

    public List<Quotation> findAll() {
        return quotationList;
    }

    private void buildList(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<QuotationJSON> quotationJSON = mapper.readValue(br, mapper.getTypeFactory().constructCollectionType(List.class, QuotationJSON.class));
        br.close();
        quotationList = new ArrayList<Quotation>();
        IShopRepository shopRepository = new ShopRepository();
        ISupplyListRepository supplyListRepository = new SupplyListRepository();
        for(QuotationJSON q : quotationJSON){
            Quotation quotation = new Quotation();
            quotation.setQuotedBy(q.quotedBy);
            quotation.setTotalPrice(q.totalPrice);
            quotation.setSupplyList(supplyListRepository.findBySchoolLevelAndYear(new School(q.school), q.level, q.year));
            quotation.setShop(shopRepository.findByName(q.shop));
            quotationList.add(quotation);
        }
    }

    private static class QuotationJSON{
        public String quotedBy;
        public double totalPrice;
        public String school;
        public int level;
        public int year;
        public String shop;
    }
}
