package com.app.reach.reach.Main
import android.view.MenuItem
import com.app.reach.reach.R
/**
 * Created by tenzin on 17/3/16.
 */
public class MainPresenter {
    private MainView view;
    private MainService service

    MainPresenter(MainView view, MainService service) {
        this.view = view
        this.service = service
    }

    public void onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_companies) {
            view.startCompanyActivity()
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
