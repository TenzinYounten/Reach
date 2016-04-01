package com.app.reach.reach.CompanyProducts;

/**
 * Created by tenzin on 24/3/16.
 */
public class UnSuccessfulGetProductsEvent {
    String failiureMessage;

    public UnSuccessfulGetProductsEvent(String failiureMessage) {
        this.failiureMessage = failiureMessage;
    }

    public String getFailiureMessage() {
        return failiureMessage;
    }
}
