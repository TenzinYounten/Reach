package com.app.reach.model.OrderDB;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by tenzin on 15/4/16.
 */
@RealmClass
public class OrderLine extends RealmObject{
    private Long id;
    private String productCode;
    private String name;
    private String companyId;
    private String productDescription;
    private Double mrpPrice;
    private Double sellingPriceWithoutTax;
    private Double sellingPriceWithTax;
    private Integer quantity;

    Integer getQuantity() {
        return quantity;
    }

    void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    Double getMrpPrice() {
        return mrpPrice;
    }

    void setMrpPrice(Double productMrp) {
        this.mrpPrice = productMrp;
    }

    Double getSellingPriceWithoutTax() {
        return sellingPriceWithoutTax;
    }

    void setSellingPriceWithoutTax(Double sellingPriceWithoutTax) {
        this.sellingPriceWithoutTax = sellingPriceWithoutTax;
    }

    double getSellingPriceWithTax() {
        return sellingPriceWithTax;
    }

    void setSellingPriceWithTax(Double sellingPriceWithTax) {
        this.sellingPriceWithTax = sellingPriceWithTax;
    }


    void setId(Long id) {
        this.id = id;
    }

    void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    void setName(String productName) {
        this.name = productName;
    }

    void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    Long getId() {

        return id;
    }

    String getProductCode() {
        return productCode;
    }

    String getName() {
        return name;
    }

    String getProductDescription() {
        return productDescription;
    }

    String getCompanyId() {
        return companyId;
    }

    void setCompanyId(String companyId) {
        this.companyId = companyId;
    }





}
