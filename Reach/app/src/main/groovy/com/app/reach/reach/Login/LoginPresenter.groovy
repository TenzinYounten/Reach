package com.app.reach.reach.Login
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.app.reach.reach.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
/**
 * Created by tenzin on 3/3/16.
 */
public class LoginPresenter {
    private LoginView view;
    private LoginService service;
    private Context context

    EventBus bus = EventBus.getDefault()



    public LoginPresenter(LoginView view, LoginService service, Context context) {
        this.view = view
        this.service = service
        this.context = context
    }

    public void onLoginClicked() {
        String username = view.getUsername();
        String password = view.getPassword();
        bus.register(this)


        if(!validateUsername(username)){
            return
        }

        if(!validatePassword(password)){
            return
        }

        if(login(username, password)){

            return
        }
    }

    public boolean validateUsername(String username) {
        if(username == null || username.isEmpty()) {
            bus.unregister(this)
            view.showUsernameError(R.string.invalid_username);
            return false
        }
        return true
    }

    public boolean validatePassword(String password) {
        if(password == null || password.isEmpty()) {
            bus.unregister(this)
            view.showPasswordError(R.string.invalid_password);
            return false
        }
        return true
    }

    public boolean login(String username, String password) {

        service.login(username, password)
        Log.d("checkLog","loginfunction check")
    }

    @Subscribe
    public void onEvent(SuccessfulLoginEvent event){
        Log.d("onEvent log", "onEvent before response"+event )
        if(event.getUser()!= null) {

            Log.d("Login onevent",""+event.getUser().username)
            SharedPreferences login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = login.edit();
            editor.putString("access_token", ""+event.getUser().accessToken);
            editor.commit();


            view.startMainActivity()
            Log.d("Checkpresenter", "npassed")
        }
        else {
            Log.d("Checkpresenter", "nothingfail")
            bus.unregister(this)
            view.showLoginError(R.string.invalid_login);
        }
    }

    @Subscribe
    public void onEvent(UnsuccessfulLoginEvent event) {
        view.showLoginFailiureMessage(event.failiureMessage)
        bus.unregister(this)
    }
}

