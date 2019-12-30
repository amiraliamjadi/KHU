package com.kharazmiuniversity.khu.models;

import com.google.gson.annotations.SerializedName;

public class Token
{

    @SerializedName("message")
    private String loginMessage;

    @SerializedName("proffessor")
    private String proffessor;


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

    public boolean getProffessor() {
        boolean proffessor;
        if (this.proffessor.equals("0"))
        {
            proffessor = false;
        }
        else {
            proffessor = true;
        }
        return proffessor;
    }

    public void setProffessor(boolean proffessor) {
        if (!proffessor)
        {
            this.proffessor = "0";
        }
        else {
            this.proffessor = "1";
        }

    }

}
