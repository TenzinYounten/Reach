package com.app.reach.reach.Login

import com.app.reach.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query;

/**
 * Created by tenzin on 3/3/16.
 */
public class LoginService {


    public interface ReachEndpointInterface {
        @POST("api/login")
        Call<User> doLogin(@Query("userrname") String username,@Query("password") String password)
    }

    ReachEndpointInterface reachEndpointInterface

    public boolean login(String username, String password) {
        boolean status = false
//        public static final String BASE_URL = "http://localhost:8080/";
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        reachEndpointInterface = retrofit.create(ReachEndpointInterface.class)
//
//        call.enqueue(new Callback<User>() {
//            @Override
//            void onResponse(Call<User> cal, Response<User> response) {
//                int statuscode = response.code()
//                User user = response.body()
//                status = 1
//            }
//
//            @Override
//            void onFailure(Call<User> cal, Throwable t) {
//            }
//        })
        //Call<User> call = reachEndpointInterface.doLogin(username, password)
        //Response<User> response = call.execute()


        return status


    }
}
