package com.app.reach.reach.Login;

import android.content.Context;
import android.content.Intent;

import com.app.reach.reach.Main.MainActivity;

/**
 * Created by tenzin on 3/3/16.
 */
public class ActivityUtil {
    private Context context;

    public ActivityUtil (Context context){
        this.context = context;

    }
    public void startMainActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}

