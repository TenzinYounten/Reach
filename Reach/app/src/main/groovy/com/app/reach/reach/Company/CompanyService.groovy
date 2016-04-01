package com.app.reach.reach.Company

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.app.reach.ReachEndPoint.ReachEndpointInterface
import com.app.reach.model.Company
import com.app.reach.reach.Login.SuccessfulLoginEvent
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Created by tenzin on 17/3/16.
 */
public class CompanyService {
    private EventBus bus = EventBus.getDefault();
    SuccessfulLoginEvent event

    public boolean getCompanyData(Context context) {
               Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ReachEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SharedPreferences login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);

        String access_token = "Bearer " +login.getString("access_token","token")
        Log.d("Aceess token",""+access_token)

        ReachEndpointInterface reachEndpointInterface = retrofit.create(ReachEndpointInterface.class)
        Call<List<Company>> call = reachEndpointInterface.getCompanies(access_token)

        call.enqueue(new Callback<List<Company>>() {

            @Override
            void onResponse(Call<List<Company>> callCompany, Response<List<Company>> response) {
                SuccessfulGetCompanyEvent event
                List<Company> companyList = response.body()
                Log.d("in enqueue","pass")
                if(response.isSuccess())
                {
                    Log.d("in Response Sucess","pass")
                    Log.d("Company list",""+companyList.dump())


                    Log.d("company name",""+companyList.companyName)

                    Log.d("contents", "present")

                }
                event = new SuccessfulGetCompanyEvent(companyList)
                Log.d("companyList",""+companyList.dump())
                Log.d("event"," "+event.dump())
                bus.post(event)
            }

            @Override
            void onFailure(Call<List<Company>> callCompany, Throwable t) {
                Log.d("in Failiure","fail"+t.getMessage())
                UnSuccessfulGetCompanyEvent event = new UnSuccessfulGetCompanyEvent(t.getMessage())
                bus.post(event)
            }
        })

        Log.d("end", "end")

    }
}
