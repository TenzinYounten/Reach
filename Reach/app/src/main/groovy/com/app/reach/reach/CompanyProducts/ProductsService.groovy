package com.app.reach.reach.CompanyProducts

import android.content.Context
import android.content.SharedPreferences
import android.text.format.DateFormat
import android.util.Log
import com.app.reach.ReachEndPoint.ReachEndpointInterface
import com.app.reach.model.OrderlineListItem
import com.app.reach.model.ProductListDB.ProductDB
import com.app.reach.model.ProductListDB.ProductListDB
import io.realm.Realm
import io.realm.RealmList
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by tenzin on 24/3/16.
 */
public class ProductsService {
    Realm realm
    private EventBus bus = EventBus.getDefault();

    public boolean getProducts(Context context, Long id) {
        Log.d("service id", "" + id)
        SharedPreferences login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        String access_token = "Bearer " + login.getString("access_token", "token")
        String time = "0-0-0 0:0:0";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ReachEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("enter", "service")
        Log.d("access token", "" + access_token)

        ReachEndpointInterface reachEndpointInterface = retrofit.create(ReachEndpointInterface.class)
        Call<List<OrderlineListItem>> call = reachEndpointInterface.getProducts(access_token, time, id)
        call.enqueue(new Callback<ArrayList<OrderlineListItem>>() {
            @Override
            void onResponse(Call<ArrayList<OrderlineListItem>> productCall, Response<ArrayList<OrderlineListItem>> response) {
                SuccessfulGetProductsEvent event
                RealmList<ProductDB> productList = new RealmList<ProductDB>()
                realm = Realm.getDefaultInstance()

                realm.beginTransaction()
                ProductListDB productListDB = realm.createObject(ProductListDB.class)
                if (response.isSuccess()) {
                    Log.d("IsSucess", "")
                    Log.d("Response Boody", "" + response.body().name)

                    response.body().each {
                        ProductDB productDB = realm.createObject(ProductDB.class)
                        productDB.id = it.id
                        productDB.productCode = it.productCode
                        productDB.name = it.name
                        productDB.companyId = it.companyId
                        productDB.productDescription = it.productDescription
                        productDB.mrpPrice = it.mrpPrice
                        productDB.sellingPriceWithTax = it.sellingPriceWithTax
                        productDB.sellingPriceWithoutTax = it.sellingPriceWithoutTax
                        productList << productDB
                    }
                    Log.d("productLits", "" + productList.dump())
                    String lastTimeOfUpdate = DateFormat.format("yyyy-MM-dd kk:mm:ss", new Date());
                    productListDB.setProductListDB(productList)
                    productListDB.setDate(lastTimeOfUpdate)
                    realm.commitTransaction()

                    Log.d("productListDb", "" + productListDB.productListDB.name)
                    /* productListDB.setDate(lastTimeOfUpdate)
                     Log.d("final Product",""+productListDB.date)*/
                }
                ArrayList<OrderlineListItem> productL = response.body()
                event = new SuccessfulGetProductsEvent(productListDB.getProductListDB())
                Log.d("service event", "" + event.productList)
                Log.d("event", " " + event.dump())
                bus.post(event)
            }

            @Override
            void onFailure(Call<ArrayList<OrderlineListItem>> productCall, Throwable t) {
                Log.d("failiure", "" + t.getMessage())
                UnSuccessfulGetProductsEvent event = new UnSuccessfulGetProductsEvent(t.getMessage())
                bus.post(event)
            }
        })
        Log.d("service", "ends")
    }

    List<OrderlineListItem> convertEventToOrderLine(RealmList<ProductDB> productDBs) {
        List<OrderlineListItem> orderlineListItems = new ArrayList<OrderlineListItem>()
        productDBs.each {
            OrderlineListItem item = new OrderlineListItem(
                    it.productDescription,
                    it.companyId,
                    it.name,
                    it.productCode,
                    it.id,
                    it.mrpPrice,
                    it.sellingPriceWithTax,
                    it.sellingPriceWithoutTax,
                    0)
            Log.d("item",""+item.name)
            orderlineListItems << item
            Log.d("orderlinelistitems",""+orderlineListItems.name)
        }
        return orderlineListItems
    }
}

