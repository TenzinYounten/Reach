package com.app.reach.reach.Login
import com.app.reach.model.User
/**
 * Created by tenzin on 8/3/16.
 */
public class SuccessfulLoginEvent {
    User user

    public SuccessfulLoginEvent(User user) {
        this.user = user
    }

    User getUser() {
        return user
    }
}
