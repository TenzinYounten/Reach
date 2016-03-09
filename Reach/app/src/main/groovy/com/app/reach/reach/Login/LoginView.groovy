package com.app.reach.reach.Login;

/**
 * Created by tenzin on 3/3/16.
 */
public interface LoginView {

    String getUsername();

    void showUsernameError(int emptyUser);

    String getPassword();

    void showPasswordError(int emptyPassword);

    void startMainActivity();

    void showLoginError(int loginfailed);
}
