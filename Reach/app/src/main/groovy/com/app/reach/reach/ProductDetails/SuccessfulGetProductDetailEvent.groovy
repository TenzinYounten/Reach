package com.app.reach.reach.ProductDetails

import com.app.reach.model.OrderlineListItem;

/**
 * Created by tenzin on 28/3/16.
 */
public class SuccessfulGetProductDetailEvent {
    OrderlineListItem product

    OrderlineListItem getProduct() {
        return product
    }

    void setProduct(OrderlineListItem product) {
        this.product = product
    }

    SuccessfulGetProductDetailEvent(OrderlineListItem product) {
        this.product = product
    }
}
