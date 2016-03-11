package com.app.reach.reach.Login
import android.util.Log
import com.app.reach.model.User
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Created by tenzin on 3/3/16.
 */
public class LoginService {

    private EventBus bus = EventBus.getDefault();


    public boolean login(String username, String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ReachEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ReachEndpointInterface reachEndpointInterface = retrofit.create(ReachEndpointInterface.class)
        LoginData loginData = new LoginData(username, password)
        Call<User> call = reachEndpointInterface.doLogin(loginData)
        Log.d("Check1", "nothing1")

        call.enqueue(new Callback<User>() {
            @Override
            void onResponse(Call<User> callAsync, Response<User> response) {
                SuccessfulLoginEvent event = null
                User user = response.body()
                if(response.isSuccess()) {
                    Log.d("Body", "" + user)
                    if (user != null) {
                        Log.d("Response (contains request infos):", " ");

                        Log.d("- username:         ", " " + user.username);
                        Log.d("- roles:          ", "" + user.roles);
                        Log.d("- token type:     ", "" + user.tokenType);
                        Log.d("- accesstoken:        ", "" + user.accessToken);
                        Log.d("- expires in: ", " " + user.expiresIn);
                        Log.d("- refresh token: ", "" + user.refreshToken);
                    }

                }
                event = new SuccessfulLoginEvent(user)
                bus.post(event)

            }

            @Override
            void onFailure(Call<User> callAsync, Throwable t) {
                Log.d("Check2", "nothing2")
                Log.d("Error :", t.getMessage())
                UnsuccessfulLoginEvent event = new UnsuccessfulLoginEvent(t.getMessage())
                bus.post(event)

            }
        })
        Log.d("Check3", "nothing3")

    }
}