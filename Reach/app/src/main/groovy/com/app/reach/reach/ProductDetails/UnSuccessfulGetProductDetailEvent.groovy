package com.app.reach.reach.ProductDetails;

/**
 * Created by tenzin on 28/3/16.
 */
public class UnSuccessfulGetProductDetailEvent {
    String failiureMessage;

    public UnSuccessfulGetProductDetailEvent(String failiureMessage) {
        this.failiureMessage = failiureMessage;
    }

    public String getFailiureMessage() {
        return failiureMessage;
    }
}
