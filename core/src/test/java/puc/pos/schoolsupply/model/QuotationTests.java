package puc.pos.schoolsupply.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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

    private static IQuotationService quotationService;
    private static IShopService shopService;
    private static SupplyList supplyList;
    private static IItemService itemService;

    @BeforeAll
    public static void setUpBeforeClass() {
        shopService = new ShopService(new ShopRepository());
        itemService = new ItemService(new ItemRepository());
        quotationService = new QuotationService(shopService);
        supplyList = new SupplyList();
        supplyList.setItems(buildSupplyListItems());
    }

    private static List<Item> buildSupplyListItems(){
        return itemService.findAll();
    }

    @Test
    public void testQuotationTotal() {
        Quotation quotation = quotationService.makeQuotation(supplyList);
        Assertions.assertNotNull(quotation);
        Assertions.assertEquals(57, quotation.getTotalPrice(),0.01);
    }
}
