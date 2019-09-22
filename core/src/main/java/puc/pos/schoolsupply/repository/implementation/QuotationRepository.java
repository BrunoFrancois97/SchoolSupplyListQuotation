package puc.pos.schoolsupply.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.School;
import puc.pos.schoolsupply.model.SupplyList;
import puc.pos.schoolsupply.repository.contract.IQuotationRepository;
import puc.pos.schoolsupply.repository.util.ResourcesManipulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class QuotationRepository implements IQuotationRepository {

    private static final String QUOTATION_JSON = ResourcesManipulator.getResourcePath("quotations.json");

    private static List<Quotation> quotationList;

    public QuotationRepository(){
        Gson gson = new Gson();
        quotationList = new ArrayList<>();
        try {
            Reader reader = new FileReader(QUOTATION_JSON);
            List<QuotationJSON> quotationJSON = gson.fromJson(reader, new TypeToken<ArrayList<QuotationJSON>>(){}.getType());
            ShopRepository shopRepository = new ShopRepository();
            SupplyListRepository supplyListRepository = new SupplyListRepository();
            for(QuotationJSON q : quotationJSON){
                Quotation quotation = new Quotation();
                quotation.setQuotedBy(q.quotedBy);
                quotation.setTotalPrice(q.totalPrice);
                quotation.setSupplyList(supplyListRepository.findBySchoolLevelAndYear(q.school, q.level, q.year));
                quotation.setShop(shopRepository.findByName(q.shop));
                quotationList.add(quotation);
            }
        } catch (FileNotFoundException e) {
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

    private static class QuotationJSON{
        private String quotedBy;
        private double totalPrice;
        private School school;
        private int level;
        private int year;
        private String shop;
    }
}
