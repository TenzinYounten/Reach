package com.app.reach.reach.ProductDetails
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.app.reach.ReachEndPoint.ReachEndpointInterface
import com.app.reach.model.OrderlineListItem
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Created by tenzin on 28/3/16.
 */
public class ProductDetailsService {
    private EventBus bus = EventBus.getDefault();
    public boolean getProductDetails(Context context, long companyId, long productId) {
        SharedPreferences login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        String access_token = "Bearer " + login.getString("access_token", "token")

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ReachEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("enter", "service")
        Log.d("access token", "" + access_token)

        ReachEndpointInterface reachEndpointInterface = retrofit.create(ReachEndpointInterface.class)
        Call<OrderlineListItem> call = reachEndpointInterface.getProduct(access_token,companyId,productId)
        call.enqueue(new Callback<OrderlineListItem>() {
            @Override
            void onResponse(Call<OrderlineListItem> productCall, Response<OrderlineListItem> response) {
                if(response.isSuccess()){
                    Log.d("IsSucess","")
                }
                SuccessfulGetProductDetailEvent event
                OrderlineListItem product = response.body()
                event = new SuccessfulGetProductDetailEvent(product)
                bus.post(event)
            }

            @Override
            void onFailure(Call<OrderlineListItem> productCall, Throwable t) {
                Log.d("failiure", "" + t.getMessage())
                UnSuccessfulGetProductDetailEvent event = new UnSuccessfulGetProductDetailEvent(t.getMessage())
                bus.post(event)
            }

        })
        Log.d("service", "ends")
    }
}
