package com.app.reach.ReachEndPoint
import com.app.reach.model.AunthenticatedUser
import com.app.reach.model.Company
import com.app.reach.model.OrderlineListItem
import com.app.reach.reach.Login.LoginData
import retrofit2.Call
import retrofit2.http.*
/**
 * Created by tenzin on 8/3/16.
 */
public interface ReachEndpointInterface {

    public static final String BASE_URL = "http://10.0.3.2:8080/"
//    http://10.0.2.2:8080/
    @POST("api/login")
    Call<AunthenticatedUser> doLogin(@Body LoginData loginData)


    @GET("api/company")
    Call<List<Company>> getCompanies(@Header("Authorization")String access_token, @Header("If-Modified-Since") time)

    @GET("api/company/{companyId}/product")
    Call<List<OrderlineListItem>> getProducts(@Header("Authorization")String access_token, @Header("If-Modified-Since") time, @Path("companyId")Long id )

    @GET("api/company/{companyId}/product/{productId}")
    Call<OrderlineListItem> getProduct(@Header("Authorization")String access_token, @Path("companyId")Long companyId, @Path("productId") Long productId )
}
