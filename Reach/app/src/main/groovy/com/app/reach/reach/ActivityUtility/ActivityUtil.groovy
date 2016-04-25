package com.app.reach.reach.ActivityUtility
import android.content.Context
import android.content.Intent
import com.app.reach.reach.Company.CompanyActivity
import com.app.reach.reach.Login.LoginActivity
import com.app.reach.reach.Main.MainActivity
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

    public void startLoginActivity() {
        context.startActivity(new Intent(context, LoginActivity.class))
    }


    public void startCompanyActivity() {
        context.startActivity(new Intent(context, CompanyActivity.class))
    }

    public void startProductActivity(Intent intent) {
        context.startActivity(intent)
    }

    public void startProductDetailsActivity(Intent intent) {
        context.startActivity(intent)
    }

    public void startOrderLineListItemsActivity(Intent intent) {
        context.startActivity(intent)
    }
}

