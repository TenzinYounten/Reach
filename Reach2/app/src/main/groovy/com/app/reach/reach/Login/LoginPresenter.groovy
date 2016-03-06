package com.app.reach.reach.Login;

import com.app.reach.reach.R;

/**
 * Created by tenzin on 3/3/16.
 */
public class LoginPresenter {
    private LoginView view;
    private LoginService service;

    public LoginPresenter(LoginView view, LoginService service) {
        this.view = view;
        this.service = service;
    }

    public void onLoginClicked() {
        String username = view.getUsername();
        String password = view.getPassword();

        if(!validateUsername(username)){
            return
        }

        if(!validatePassword(password)){
            return
        }

        if(loginSucceded(username, password)){
            return
        }
    }

    public boolean validateUsername(String username) {
        if(username == null || username.isEmpty()) {
            view.showUsernameError(R.string.invalid_username);
            return false
        }
        return true
    }

    public boolean validatePassword(String password) {
        if(password == null || password.isEmpty()) {
            view.showPasswordError(R.string.invalid_password);
            return false
        }
        return true
    }

    public boolean loginSucceded(String username, String password) {
        if(service.login(username,password)) {
            view.startMainActivity()
        }
        view.showLoginError(R.string.invalid_login);
    }
}

