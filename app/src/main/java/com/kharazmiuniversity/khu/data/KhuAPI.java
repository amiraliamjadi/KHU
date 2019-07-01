package com.kharazmiuniversity.khu.data;

import com.kharazmiuniversity.khu.models.Group;
import com.kharazmiuniversity.khu.models.GroupResponse;
import com.kharazmiuniversity.khu.models.TokenResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface KhuAPI
{
    String BASE_URL = "192.168.40.3";

    @Headers({

            "X-Backtory-Authentication-Id:5a1d4b3de4b0afa16474fabd",
            "X-Backtory-Authentication-Key:5a1d4b3de4b0ce09cd4655c8"

    })

    @FormUrlEncoded
    @POST("auth/login?p=")
    Call<TokenResponse> loginUser(

            @Field("username") String username,
            @Field("password") String password

    );

    @Headers("")
    @GET("")
    Call<GroupResponse> getGroups(

            @Header("") String authorization

    );



    interface LoginUserCallback
    {
        void onResponse(boolean successful , String errorDescription , TokenResponse tokenResponse);

        void onFailure(String cause);
    }

    interface getGroupsCallback
    {
        void onResponse(List<Group> groupList);

        void onFailure( String cause);

    }

}
