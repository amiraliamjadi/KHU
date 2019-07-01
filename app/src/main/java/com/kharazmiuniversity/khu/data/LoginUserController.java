package com.kharazmiuniversity.khu.data;

import com.kharazmiuniversity.khu.models.TokenResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginUserController
{
    KhuAPI.LoginUserCallback loginUserCallback;

    public LoginUserController(KhuAPI.LoginUserCallback loginUserCallback) {
        this.loginUserCallback = loginUserCallback;
    }

    public void start(String username , String password)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KhuAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KhuAPI khuAPI = retrofit.create(KhuAPI.class);
        Call<TokenResponse> call = khuAPI.loginUser(username,password);

        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {

                if (response.isSuccessful())
                {
                    loginUserCallback.onResponse(true,null,response.body());
                }

            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });

    }
}
