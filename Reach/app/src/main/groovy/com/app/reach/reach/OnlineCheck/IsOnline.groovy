package com.app.reach.reach.OnlineCheck;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by tenzin on 26/4/16.
 */
public class IsOnline  {
    public boolean getIsOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo()
        if(networkInfo != null) {
            return true
        }
        else {
            return false
        }
    }

}
