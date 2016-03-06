package com.app.reach.reach.Login;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.reach.reach.R;

public class LoginActivity extends AppCompatActivity implements  LoginView{

    EditText usernameView;
    EditText passwordView;
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameView = (EditText) findViewById(R.id.username);
        passwordView = (EditText) findViewById(R.id.password);
        presenter = new LoginPresenter(this, new LoginService());


    }

    public void onLoginClicked(View view) {
        presenter.onLoginClicked();

    }

    @Override
    public String getUsername() {
        return usernameView.getText().toString();
    }

    @Override
    public void showUsernameError(int emptyUser) {
        usernameView.setError(getString(emptyUser));

    }


    @Override
    public String getPassword() {
        return passwordView.getText().toString();
    }

    @Override
    public void showPasswordError(int emptyPassword) {
        passwordView.setError(getString(emptyPassword));
    }


    @Override
    public void startMainActivity() {
        new ActivityUtil(this).startMainActivity();
    }

    @Override
    public void showLoginError(int loginfailed) {
        Toast.makeText(this, getString(loginfailed), Toast.LENGTH_LONG).show();
    }

}

