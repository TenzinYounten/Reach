package com.app.reach.reach.Company
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import com.app.reach.reach.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
/**
 * Created by tenzin on 17/3/16.
 */
public class CompanyPresenter {
    private CompanyView view
    private CompanyService service
    EventBus bus = EventBus.getDefault()
    private Context context

    public CompanyPresenter(CompanyView view, CompanyService service,Context context) {
        this.view = view;
        this.service = service;
        this.context = context
    }

    public void onCreate() {
        bus.register(this)
        if(getCompanyData()){
            return
        }

    }

    public boolean getCompanyData() {
        Log.d("getCompanyData","processing")

        service.getCompanyData(context)
    }

    @Subscribe
    public void onEvent(SuccessfulGetCompanyEvent event){
        Log.d("onEvent log", "onEvent before response"+event.dump() )
        if(event.getCompanyList()!= null) {
            view.listCompanies(event)
            Log.d("getcompany", "passed")
        }
        else {
            Log.d("getcompany", "fail")
            bus.unregister(this)
            view.showNoCompaniesRegisteredError(R.string.invalid_login);
        }
    }

    @Subscribe
    public void onEvent(UnSuccessfulGetCompanyEvent event) {
        view.showNetworkFailiureMessage(event.failiureMessage)
        bus.unregister(this)
    }

    void onItemClick(Intent intent) {
        view.startProductActivity(intent)
    }
    public void onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_companies) {

        } else if (id == R.id.nav_category) {

        } else if (id == R.id.nav_aboutus) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


    }

    public onOptionItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
    }
}
