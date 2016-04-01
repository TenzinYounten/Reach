package com.app.reach.reach.CompanyProducts
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.app.reach.ReachEndPoint.ReachEndpointInterface
import com.app.reach.model.Product
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

    private EventBus bus = EventBus.getDefault();

    public boolean getProducts(Context context, Long id) {
        Log.d("service id", "" + id)
        SharedPreferences login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        String access_token = "Bearer " + login.getString("access_token", "token")

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ReachEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("enter", "service")
        Log.d("access token", "" + access_token)

        ReachEndpointInterface reachEndpointInterface = retrofit.create(ReachEndpointInterface.class)
        Call<List<Product>> call = reachEndpointInterface.getProducts(access_token, id)
        call.enqueue(new Callback<List<Product>>() {
            @Override
            void onResponse(Call<List<Product>> productCall, Response<List<Product>> response) {
                if(response.isSuccess()){
                    Log.d("IsSucess","")
                }
                SuccessfulGetProductsEvent event
                List<Product> productList = response.body()
                event = new SuccessfulGetProductsEvent(productList)
                bus.post(event)
            }

            @Override
            void onFailure(Call<List<Product>> productCall, Throwable t) {
                Log.d("failiure", "" + t.getMessage())
                UnSuccessfulGetProductsEvent event = new UnSuccessfulGetProductsEvent(t.getMessage())
                bus.post(event)
            }
        })
        Log.d("service", "ends")
    }
}
