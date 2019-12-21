package com.kharazmiuniversity.khu.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupResponse
{
    @SerializedName("records")
    List<Group> groups;


    public GroupResponse() {
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
