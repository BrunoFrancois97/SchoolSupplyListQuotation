package puc.pos.schoolsupply.model;

import org.junit.Assert;
import org.junit.Test;
import puc.pos.schoolsupply.service.contract.IQuotationService;
import puc.pos.schoolsupply.service.contract.IShopService;
import puc.pos.schoolsupply.service.implementation.QuotationService;
import puc.pos.schoolsupply.service.implementation.ShopService;

import java.util.ArrayList;

public class QuotationTests {

    private IQuotationService quotationService;
    private IShopService shopService;
    private SupplyList supplyList;


    public void setUpBeforeClass() {
        shopService = new ShopService();
        quotationService = new QuotationService(shopService);
        supplyList = new SupplyList();
        supplyList.setItems(buildSupplyListItems());
    }

    private ArrayList<Item> buildSupplyListItems(){
        ArrayList<Item> items = new ArrayList<Item>();
        Item i1 = new Item();
        i1.setDescription("Lapis");
        i1.setQuantity(2);

        Item i2 = new Item();
        i2.setDescription("Caneta");
        i2.setQuantity(2);

        items.add(i1);
        items.add(i2);
        return items;
    }

    @Test
    public void testQuotationTotal() {
        this.setUpBeforeClass();
        Quotation quotation = quotationService.makeQuotation(supplyList);
        Assert.assertEquals(10, quotation.getTotalPrice());
    }
}
