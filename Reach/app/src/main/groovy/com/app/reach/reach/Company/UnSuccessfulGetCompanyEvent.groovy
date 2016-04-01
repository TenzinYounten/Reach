package com.app.reach.reach.Company;

/**
 * Created by tenzin on 17/3/16.
 */
public class UnSuccessfulGetCompanyEvent {
    String failiureMessage;

    public UnSuccessfulGetCompanyEvent(String failiureMessage) {
        this.failiureMessage = failiureMessage;
    }

    public String getFailiureMessage() {
        return failiureMessage;
    }
}
