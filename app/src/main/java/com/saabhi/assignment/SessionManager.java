package com.saabhi.assignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LoginPref";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createLoginSession(String name, String email){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }


    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
