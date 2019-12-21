package com.kharazmiuniversity.khu.data;

import com.kharazmiuniversity.khu.models.ErrorResponse;
import com.kharazmiuniversity.khu.models.Group;
import com.kharazmiuniversity.khu.models.GroupResponse;
import com.kharazmiuniversity.khu.models.Token;
import com.kharazmiuniversity.khu.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface KhuAPI
{
    String BASE_URL = "http://10.0.2.2";



    @POST("rest-api-authentication-example/api/login.php")
    Call<Token> loginUser(

            @Body User user
    );


    @POST("rest-api-authentication-example/api/get_groups.php")
    Call<GroupResponse> getGroups(


    );



    interface LoginUserCallback
    {
        void onResponse(boolean successful , ErrorResponse errorResponse, Token token );

        void onFailure(String cause);
    }

    interface getGroupsCallback
    {
        void onResponse(List<Group> groupList);

        void onFailure( String cause);

    }

}
