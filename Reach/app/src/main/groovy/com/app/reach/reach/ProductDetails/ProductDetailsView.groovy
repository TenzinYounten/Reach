package com.app.reach.reach.ProductDetails;

/**
 * Created by tenzin on 28/3/16.
 */
public interface ProductDetailsView {

    def listProduct(SuccessfulGetProductDetailEvent successfulGetProductDetailEvent);

    def showNetworkFailiureMessage(String s)

    void showNoProductsRegisteredError(int i)
}
