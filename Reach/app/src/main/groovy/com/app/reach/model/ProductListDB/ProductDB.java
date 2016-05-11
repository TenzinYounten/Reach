package com.app.reach.model.ProductListDB;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by tenzin on 25/4/16.
 */
@RealmClass
public class ProductDB extends RealmObject {
    private Long id;
    private String productCode;
    private String name;
    private String companyId;
    private String productDescription;
    private Double mrpPrice;
    private Double sellingPriceWithoutTax;
    private Double sellingPriceWithTax;
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

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
