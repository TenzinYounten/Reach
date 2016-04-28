package com.app.reach.reach.CompanyProducts

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import com.app.reach.model.OrderlineListItem
import com.app.reach.model.ProductListDB.ProductDB
import com.app.reach.reach.Company.UnSuccessfulGetCompanyEvent
import com.app.reach.reach.R
import io.realm.RealmList
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
/**
 * Created by tenzin on 24/3/16.
 */
public class ProductsPresenter {
    private ProductsView view
    private ProductsService service

    EventBus bus = EventBus.getDefault()

    public ProductsPresenter(ProductsView view, ProductsService service) {
        this.view = view;
        this.service = service;
    }

    public void onCreate(Context context, Long id) {
        bus.register(this)
        if (getProducts(context, id)) {
            return
        }
    }

    boolean getProducts(Context context, Long id) {
        service.getProducts(context, id)
    }

    public void viewOrderItems() {
        view.viewOrderItems()
    }

    @Subscribe
    public void onEvent(SuccessfulGetProductsEvent event) {
        Log.d("onEvent log", "onEvent before response" + event.productList.productCode.dump())
        if (event.getProductList() != null) {
            view.listProducts(event)
            Log.d("getproduct", "passed")
        } else {
            Log.d("getproduct", "fail")
            bus.unregister(this)
            view.showNoProductsRegisteredError(R.string.invalid_login);
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

    void onProceedClick(Intent intent) {
        view.startOrderLineListActivity(intent)
    }

    List<OrderlineListItem> convertEventToOrderLine(RealmList<ProductDB> productDBs) {
        Log.d("Productdbs presenter",""+productDBs.name)
        List<OrderlineListItem> orderlineListItems = service.convertEventToOrderLine(productDBs)
        return orderlineListItems
    }
}