package com.app.reach.reach.ProductDetails

import com.app.reach.model.Product;

/**
 * Created by tenzin on 28/3/16.
 */
public class SuccessfulGetProductDetailEvent {
    Product product

    Product getProduct() {
        return product
    }

    void setProduct(Product product) {
        this.product = product
    }

    SuccessfulGetProductDetailEvent(Product product) {
        this.product = product
    }
}
