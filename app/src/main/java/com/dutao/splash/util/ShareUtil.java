package com.dutao.splash.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dutao on 2015/7/3.
 */
public class ShareUtil {
    private static String SP_NAME = "config";
    private static SharedPreferences sharedPreferences;

    public static void saveBooleanData(Context context,String key,Boolean value){
        if (sharedPreferences==null){
            sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putBoolean(key,value).commit();
    }

    public static Boolean getBooleanData(Context context,String key){
        if (sharedPreferences==null){
            sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(key,true);
    }
}
