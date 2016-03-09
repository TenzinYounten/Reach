package com.app.reach.reach.Login
import com.app.reach.model.User
/**
 * Created by tenzin on 8/3/16.
 */
public class LoginEvent {
    User user

    public LoginEvent(User user) {
        this.user = user
    }

    User getUser() {
        return user
    }
}
