package com.kharazmiuniversity.khu.models;

import com.google.gson.annotations.SerializedName;

public class Group
{
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;


    public Group()
    {

    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
