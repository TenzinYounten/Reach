package com.app.reach.reach.CompanyProducts

import android.content.Context
import android.content.Intent
import android.util.Log
import com.app.reach.reach.Company.UnSuccessfulGetCompanyEvent
import com.app.reach.reach.R
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
        if(getProducts(context,id)) {
            return
        }
    }

    boolean getProducts(Context context, Long id) {
        service.getProducts(context, id)
    }

    @Subscribe
    public void onEvent(SuccessfulGetProductsEvent event){
        Log.d("onEvent log", "onEvent before response"+event.productList.productCode.dump() )
        if(event.getProductList()!= null) {
            view.listProducts(event)
            Log.d("getproduct", "passed")
        }
        else {
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
}
