package puc.pos.schoolsupply.factory;

import puc.pos.schoolsupply.model.Item;
import puc.pos.schoolsupply.model.Product;
import puc.pos.schoolsupply.model.Quotation;
import puc.pos.schoolsupply.model.dto.QuotationDto;
import puc.pos.schoolsupply.model.dto.util.LevelDto;
import puc.pos.schoolsupply.model.dto.util.QuotationProductDto;

import java.util.ArrayList;
import java.util.List;

public class QuotationDtoFactory {

    private double totalPrice = 0;

    public QuotationDto createQuotationDto(Quotation quotation){

        QuotationDto quotationDto = new QuotationDto();

        quotationDto.setShop(quotation.getShop().getName());
        quotationDto.setSchoolName(quotation.getSupplyList().getSchool().getName());
        quotationDto.setLevel(createLevel(quotation));
        quotationDto.setProducts(createProductList(quotation));
        quotationDto.setTotalPrice(totalPrice);

        return quotationDto;
    }

    private LevelDto createLevel(Quotation quotation){
        return new LevelDto(quotation.getSupplyList().getLevel(), quotation.getSupplyList().getLevel() + "° ano");
    }

    private List<QuotationProductDto> createProductList(Quotation quotation){

        List<QuotationProductDto> products = new ArrayList<>();

        for(Item i : quotation.getSupplyList().getItems()){
            QuotationProductDto product = new QuotationProductDto();
            product.setProductName(i.getDescription());
            product.setQuantity(i.getQuantity());
            product.setIndividualPrice(createIndividualPrice(quotation, i));
            product.setExtendedPrice(product.getIndividualPrice() * product.getQuantity());
            products.add(product);
            totalPrice += product.getExtendedPrice();
        }

        return products;
    }

    private double createIndividualPrice(Quotation quotation, Item item){
        List<Product> shopProducts = quotation.getShop().getProducts();
        for(Product p : shopProducts){
            if(p.getDescription().equals(item.getDescription())){
                return p.getPrice();
            }
        }
        return 0;
    }

}
