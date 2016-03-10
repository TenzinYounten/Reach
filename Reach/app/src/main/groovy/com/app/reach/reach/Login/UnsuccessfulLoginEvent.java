package com.app.reach.reach.Login;

/**
 * Created by tenzin on 10/3/16.
 */
public class UnsuccessfulLoginEvent {
    String failiureMessage;

    public UnsuccessfulLoginEvent(String failiureMessage) {
        this.failiureMessage = failiureMessage;
    }

    public String getFailiureMessage() {
        return failiureMessage;
    }
}
