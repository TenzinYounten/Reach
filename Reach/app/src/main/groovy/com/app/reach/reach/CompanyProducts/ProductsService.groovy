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
        call.enqueue(new Callback< ArrayList<OrderlineListItem>>() {
            @Override
            void onResponse(Call<ArrayList<OrderlineListItem>> productCall, Response<ArrayList<OrderlineListItem>> response) {
                RealmList<ProductDB> productListDB = new RealmList<ProductDB>()
                realm = Realm.getDefaultInstance()
                ProductListDB productList = realm.createObject(ProductListDB.class)
                realm.beginTransaction()
                if(response.isSuccess()){
                    Log.d("IsSucess","")

                    response.body().each {
                        ProductDB productDB = realm.createObject(ProductDB.class)
                        productDB.id = it.id
                        productDB.productCode = it.id
                        productDB.name = it.name
                        productDB.companyId = it.companyId
                        productDB.productDescription = it.productDescription
                        productDB.mrpPrice = it.mrpPrice
                        productDB.sellingPriceWithTax = it.sellingPriceWithTax
                        productDB.sellingPriceWithoutTax = it.sellingPriceWithoutTax
                        productListDB << productDB
                    }
                    String lastUpdateTime = DateFormat.format("yyyy-MM-dd kk:mm:ss", new java.util.Date());
                    Log.d("Date",""+lastUpdateTime)
                    productList.setListDBs(productListDB)
                    productList.setDate(lastUpdateTime)
                    realm.commitTransaction()
                }
                SuccessfulGetProductsEvent event
                ArrayList<OrderlineListItem> productsList = response.body()
                event = new SuccessfulGetProductsEvent(productList.getListDBs())
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
}
