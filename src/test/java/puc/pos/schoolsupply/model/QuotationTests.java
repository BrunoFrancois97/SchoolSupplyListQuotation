package puc.pos.schoolsupply.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import puc.pos.schoolsupply.repository.implementation.ItemRepository;
import puc.pos.schoolsupply.repository.implementation.ShopRepository;
import puc.pos.schoolsupply.service.contract.IItemService;
import puc.pos.schoolsupply.service.contract.IQuotationService;
import puc.pos.schoolsupply.service.contract.IShopService;
import puc.pos.schoolsupply.service.implementation.ItemService;
import puc.pos.schoolsupply.service.implementation.QuotationService;
import puc.pos.schoolsupply.service.implementation.ShopService;

import java.util.List;

public class QuotationTests {

    private IQuotationService quotationService;
    private IShopService shopService;
    private SupplyList supplyList;
    private IItemService itemService;

    @Before
    public void setUpBeforeClass() {
        shopService = new ShopService(new ShopRepository());
        itemService = new ItemService(new ItemRepository());
        quotationService = new QuotationService(shopService);
        supplyList = new SupplyList();
        supplyList.setItems(buildSupplyListItems());
    }

    private List<Item> buildSupplyListItems(){
        return itemService.findAll();
    }

    @Test
    public void testQuotationTotal() {
        Quotation quotation = quotationService.makeQuotation(supplyList);
        Assert.assertEquals(52.8, quotation.getTotalPrice(),0.01);
    }
}
