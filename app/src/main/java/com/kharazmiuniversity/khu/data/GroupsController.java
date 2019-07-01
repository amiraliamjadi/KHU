package com.kharazmiuniversity.khu.data;

import com.kharazmiuniversity.khu.models.GroupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GroupsController
{
    KhuAPI.getGroupsCallback groupsCallback;

    public GroupsController(KhuAPI.getGroupsCallback groupsCallback) {
        this.groupsCallback = groupsCallback;
    }

    public void start(String authorization)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KhuAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KhuAPI khuAPI = retrofit.create(KhuAPI.class);
        Call<GroupResponse> call = khuAPI.getGroups(authorization);
        call.enqueue(new Callback<GroupResponse>() {
            @Override
            public void onResponse(Call<GroupResponse> call, Response<GroupResponse> response)
            {
                if (response.isSuccessful())
                {
                    groupsCallback.onResponse(response.body().getGroups());
                } else {

                }
            }

            @Override
            public void onFailure(Call<GroupResponse> call, Throwable t)
            {
                groupsCallback.onFailure(t.getMessage());
            }
        });

    }
}
