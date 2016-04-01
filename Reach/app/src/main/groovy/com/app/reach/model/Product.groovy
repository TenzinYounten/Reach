package com.app.reach.model;

/**
 * Created by tenzin on 17/3/16.
 */
public class Product {
    Long id
    String productCode
    String name
    Company company
    String productDescription
    BigDecimal mrpPrice
    BigDecimal sellingPriceWithoutTax
    BigDecimal sellingPriceWithTax


    BigDecimal getMrpPrice() {
        return mrpPrice
    }

    void setMrpPrice(BigDecimal productMrp) {
        this.mrpPrice = productMrp
    }

    BigDecimal getSellingPriceWithoutTax() {
        return sellingPriceWithoutTax
    }

    void setSellingPriceWithoutTax(BigDecimal sellingPriceWithoutTax) {
        this.sellingPriceWithoutTax = sellingPriceWithoutTax
    }

    BigDecimal getSellingPriceWithTax() {
        return sellingPriceWithTax
    }

    void setSellingPriceWithTax(BigDecimal sellingPriceWithTax) {
        this.sellingPriceWithTax = sellingPriceWithTax
    }


    void setId(Long id) {
        this.id = id
    }

    void setProductCode(String productCode) {
        this.productCode = productCode
    }

    void setName(String productName) {
        this.name = productName
    }

    void setCompany(Company company) {
        this.company = company
    }

    void setProductDescription(String productDescription) {
        this.productDescription = productDescription
    }

    Long getId() {

        return id
    }

    String getProductCode() {
        return productCode
    }

    String getName() {
        return name
    }

    Company getCompany() {
        return company
    }

    String getProductDescription() {
        return productDescription
    }

    Product(String productDescription, Company company, String name, String productCode, Long id,BigDecimal mrpPrice, BigDecimal sellingPriceWithoutTax, BigDecimal sellingPriceWithTax) {
        this.mrpPrice = mrpPrice
        this.sellingPriceWithoutTax = sellingPriceWithoutTax
        this.sellingPriceWithTax = sellingPriceWithTax
        this.productDescription = productDescription
        this.company = company
        this.name = name
        this.productCode = productCode
        this.id = id
    }
}
