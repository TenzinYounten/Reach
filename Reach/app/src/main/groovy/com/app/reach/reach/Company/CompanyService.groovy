package com.app.reach.reach.Company

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.app.reach.ReachEndPoint.ReachEndpointInterface
import com.app.reach.model.Company
import com.app.reach.model.CompanyDB.CompanyDB
import com.app.reach.model.CompanyDB.CompanyListDB
import com.app.reach.reach.Login.SuccessfulLoginEvent
import com.app.reach.reach.OnlineCheck.IsOnline
import io.realm.Realm
import io.realm.RealmList
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
    IsOnline isOnline = new IsOnline()
    String time = "0-0-0 0:0:0"
    Realm realm;

    public boolean getCompanyData(Context context) {
        SharedPreferences login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        String access_token = "Bearer " + login.getString("access_token", "token")
        Log.d("Aceess token", "" + access_token)
        Boolean onlineStatus = isOnline.getIsOnline(context)
        /*if (!onlineStatus) {*/
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ReachEndpointInterface.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            ReachEndpointInterface reachEndpointInterface = retrofit.create(ReachEndpointInterface.class)
            Call<List<Company>> call = reachEndpointInterface.getCompanies(access_token, time)

            call.enqueue(new Callback<List<Company>>() {
                @Override
                void onResponse(Call<List<Company>> callCompany, Response<List<Company>> response) {
                    SuccessfulGetCompanyEvent event
                    RealmList<CompanyDB> companyDBList = new RealmList<CompanyDB>()
                    List<Company> companyList = response.body()
                    realm = Realm.getDefaultInstance()
                    realm.beginTransaction()
                    CompanyListDB companyListDB = realm.createObject(CompanyListDB.class)
                    if (response.isSuccess()) {

                        Log.d("in enqueue", "pass")
                        response.body().each {
                            CompanyDB companyDB = realm.createObject(CompanyDB.class)
                            companyDB.id = it.id
                            companyDB.companyCode = it.companyCode
                            companyDB.companyName = it.companyName
                            companyDB.active = it.active
                            companyDBList << companyDB
                        }

                        companyListDB.setCompanyListDB(companyDBList)
                        realm.commitTransaction()

                        Log.d("in Response Sucess", "pass")
                        Log.d("Company list", "" + response.body().dump())
                        Log.d("company name", "" + response.body().companyName)
                        Log.d("contents", "present")

                    }
                    event = new SuccessfulGetCompanyEvent(companyListDB.getCompanyListDB())
                    Log.d("event", " " + event.dump())
                    bus.post(event)
                }

                @Override
                void onFailure(Call<List<Company>> callCompany, Throwable t) {
                    Log.d("in Failiure", "fail" + t.getMessage())
                    UnSuccessfulGetCompanyEvent event = new UnSuccessfulGetCompanyEvent(t.getMessage())
                    bus.post(event)
                }
            })

            Log.d("end", "end")
        /*}*/
      /*  else {
            RealmList<CompanyDB> companyDBList = new RealmList<CompanyDB>()
            RealmResults<CompanyDB> realmResults = realm.where(CompanyDB.class).findFirst()
            Log.d("RealmResult",""+realmResults.class)
            Log.d("RealmResult",""+realmResults.dump())
            event = new SuccessfulGetCompanyEvent(realmResults)
        }*/

    }
}