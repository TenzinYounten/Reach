package com.app.reach.reach.ProductDetails
import android.content.Context
import android.util.Log
import com.app.reach.reach.Company.UnSuccessfulGetCompanyEvent
import com.app.reach.reach.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
/**
 * Created by tenzin on 28/3/16.
 */
public class ProductDetailsPresenter {
    private ProductDetailsService productDetailsService
    private ProductDetailsView productDetailsView
    EventBus bus = EventBus.getDefault()

    ProductDetailsPresenter(ProductDetailsView productDetailsView, ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService
        this.productDetailsView = productDetailsView
    }

    public void onCreate(Context context, long companyId, long productId) {
        bus.register(this)
        if(getProductDetails(context,companyId,productId)) {
            return
        }
    }

    boolean getProductDetails(Context context, long companyId, long productId) {
        productDetailsService.getProductDetails(context,companyId,productId)
    }

    @Subscribe
    public void onEvent(SuccessfulGetProductDetailEvent event){
        Log.d("onEvent log", "onEvent before response"+event.product.productCode.dump() )
        if(event.getProduct()!= null) {
            productDetailsView.listProduct(event)
            Log.d("getproduct", "passed")
        }
        else {
            Log.d("getproduct", "fail")
            bus.unregister(this)
            productDetailsView.showNoProductsRegisteredError(R.string.invalid_login);
        }
    }

    @Subscribe
    public void onEvent(UnSuccessfulGetCompanyEvent event) {
        productDetailsView.showNetworkFailiureMessage(event.failiureMessage)
        bus.unregister(this)
    }
}
