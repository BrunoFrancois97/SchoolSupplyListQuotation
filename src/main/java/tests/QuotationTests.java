package tests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import puc.pos.schoolsupply.model.Item;
import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.SupplyList;
import service.contract.IQuotationService;
import service.contract.IShopService;
import service.implementation.QuotationService;
import service.implementation.ShopService;

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
