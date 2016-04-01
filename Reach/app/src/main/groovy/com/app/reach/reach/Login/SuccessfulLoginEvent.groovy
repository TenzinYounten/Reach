package com.app.reach.reach.Login
import com.app.reach.model.AunthenticatedUser
/**
 * Created by tenzin on 8/3/16.
 */
public class SuccessfulLoginEvent {
    AunthenticatedUser user

    public SuccessfulLoginEvent(AunthenticatedUser user) {
        this.user = user
    }

    AunthenticatedUser getUser() {
        return user
    }
}
