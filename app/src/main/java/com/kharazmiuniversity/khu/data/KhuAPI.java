package com.kharazmiuniversity.khu.data;

import com.kharazmiuniversity.khu.models.Channel;
import com.kharazmiuniversity.khu.models.ErrorResponse;
import com.kharazmiuniversity.khu.models.GetObject;
import com.kharazmiuniversity.khu.models.Group;
import com.kharazmiuniversity.khu.models.ObjectsResponse;
import com.kharazmiuniversity.khu.models.Token;
import com.kharazmiuniversity.khu.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface KhuAPI
{
    String BASE_URL = "http://10.0.2.2";



    @POST("khu_mobile_api/api/login.php")
    Call<Token> loginUser(

            @Body User user
    );


    @POST("khu_mobile_api/api/get_groups.php")
    Call<ObjectsResponse> getObjectsMethod(

            @Body GetObject getObject

    );



    interface LoginUserCallback
    {
        void onResponse(boolean successful , ErrorResponse errorResponse, Token token );

        void onFailure(String cause);
    }

    interface getObjectsCallback
    {
        void onResponse(List<Group> groupList, List<Channel> channelList);

        void onFailure( String cause);

    }

}
