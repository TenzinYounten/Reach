package com.app.reach.reach.Login
import com.app.reach.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
/**
 * Created by tenzin on 8/3/16.
 */
public interface ReachEndpointInterface {
    public static final String BASE_URL = "http://10.0.2.2:8080/"

    @POST("api/login")
    Call<User> doLogin(@Body LoginData loginData)

}