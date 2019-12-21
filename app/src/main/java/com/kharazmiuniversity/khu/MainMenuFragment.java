package com.kharazmiuniversity.khu;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.kharazmiuniversity.khu.data.GroupsController;
import com.kharazmiuniversity.khu.data.KhuAPI;
import com.kharazmiuniversity.khu.models.Group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainMenuFragment extends Fragment
{

   private RecyclerView groups;
   private List<Group> groupList = new ArrayList<>();
   private GroupAdapter groupAdapter;
   private ProgressBar progressBar;

    // marboot be gereftan e groups ha
    KhuAPI.getGroupsCallback groupsCallback = new KhuAPI.getGroupsCallback() {
        @Override
        public void onResponse(List<Group> inputList)
        {

            if (progressBar.isShown())
            {
                progressBar.setVisibility(View.INVISIBLE);
            }

            groupList.clear();

            Collections.sort(inputList, new Comparator<Group>() {
                @Override
                public int compare(Group x, Group y) {
                    return x.getName().compareTo(y.getName());
                }
            });

            groupList.addAll(inputList);
            groupAdapter.notifyDataSetChanged();

        }

        @Override
        public void onFailure(String cause) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu , container ,false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        findViews(view);
        initGroupList();

        progressBar.setVisibility(View.VISIBLE);

        GroupsController groupsController = new GroupsController(groupsCallback);
        groupsController.start();
    }

    private void findViews(View view)
    {
        groups = view.findViewById(R.id.groups);
        progressBar = view.findViewById(R.id.menu_progress_bar);
    }

    private void initGroupList()
    {
        groupAdapter = new GroupAdapter(groupList , getContext());
        groups.setLayoutManager(new LinearLayoutManager(getActivity()));
        groups.setAdapter(groupAdapter);
    }

}
