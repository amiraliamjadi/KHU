package com.kharazmiuniversity.khu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kharazmiuniversity.khu.data.GroupMessageController;
import com.kharazmiuniversity.khu.data.KhuAPI;
import com.kharazmiuniversity.khu.models.Group;
import com.kharazmiuniversity.khu.models.GroupMessage;
import com.kharazmiuniversity.khu.models.RequestGroupMessage;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GroupChatActivity2 extends AppCompatActivity
{

    private RecyclerView mMessageRecycler;
    public GroupMessageAdapter mMessageAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);


        mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new GroupMessageAdapter(this,GroupAdapter.messageList);
        mMessageRecycler.setAdapter(mMessageAdapter);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));


    }








}
