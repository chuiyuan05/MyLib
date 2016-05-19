package com.woaigsc.mylib.designpattern.mvp.login.model;

/**
 * Created by chuiyuan on 16-5-19.
 */
public class UserModel implements IUser{
    String name ;
    String passwd ;

    public UserModel(String name, String passwd){
        this.name = name ;
        this.passwd = passwd ;
    }

    @Override
    public boolean checkUserValidity(String name, String passwd) {
        if(name != null && passwd != null && name.equals(getName())
                && passwd.equals(getPasswd())){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }
}
