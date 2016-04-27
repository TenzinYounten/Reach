package com.app.reach.model.ProductListDB;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by tenzin on 25/4/16.
 */
@RealmClass
public class ProductDB extends RealmObject {
    Long id;
    String productCode;
    String name;
    String companyId;
    String productDescription;
    Double mrpPrice;
    Double sellingPriceWithoutTax;
    Double sellingPriceWithTax;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(Double mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public Double getSellingPriceWithoutTax() {
        return sellingPriceWithoutTax;
    }

    public void setSellingPriceWithoutTax(Double sellingPriceWithoutTax) {
        this.sellingPriceWithoutTax = sellingPriceWithoutTax;
    }

    public Double getSellingPriceWithTax() {
        return sellingPriceWithTax;
    }

    public void setSellingPriceWithTax(Double sellingPriceWithTax) {
        this.sellingPriceWithTax = sellingPriceWithTax;
    }

}
