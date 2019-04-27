package com.mytaxi.android_demo.activities;

import java.util.HashMap;
import java.util.Map;

public class ReadJSON {
    private String username;
    private String password;
    //private Object[] results;
    private Object[] login;
    private Map<String, Object> results = new HashMap<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, Object> getResults() {
        return results;
    }

    public void setResults(Map<String, Object> results) {
        this.results = results;
    }

    public void setLogin(Object[] login) {
        this.login = login;
    }

    public Object[] getLogin() {
        return login;
    }



}
