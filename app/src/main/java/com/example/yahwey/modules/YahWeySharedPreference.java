package com.example.yahwey.modules;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class YahWeySharedPreference {
    private static final String DEFAULT_VALUE = "";
    private static YahWeySharedPreference outInstance = new YahWeySharedPreference();
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;


    private YahWeySharedPreference(){}

    public static YahWeySharedPreference getInstance(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
        return outInstance;
    }

    public void savePreference(String key, String value){
        editor.putString(key,value);
        editor.commit();
    }

    public void savePreference(String key, int value){
        editor.putInt(key, value);
        editor.commit();
    }

    public  void deletePreference(String Key) {
        editor.remove(Key);
        editor.commit();
    }


    public boolean clearPreference(){
        return editor.clear().commit();
    }


    public String retrievePreference(String key){
        return sharedPreferences.getString(key, DEFAULT_VALUE);
    }

    public int retrievePreferenceInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }
}
