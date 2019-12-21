package com.kharazmiuniversity.khu.models;

import com.google.gson.annotations.SerializedName;

public class Token
{

    @SerializedName("message")
    private String loginMessage;

    @SerializedName("jwt")
    private String jwt;


    public Token() {
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
