package com.app.reach.reach.CompanyProducts;

import android.content.Intent;

/**
 * Created by tenzin on 24/3/16.
 */
public interface ProductsView {
    def listProducts(SuccessfulGetProductsEvent p);

    void showNoProductsRegisteredError(int p);

    def showNetworkFailiureMessage(String p);

    void startProductActivity(Intent p);
}
