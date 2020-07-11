package com.androidproject.GameEdukasiPemahamanAnak;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class Preferences {
    static final String NAMA = "nama";

private static SharedPreferences getSharedPreference(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
}

public static void  setLoggedInUser(Context context, String username){
    SharedPreferences.Editor editor = getSharedPreference(context).edit();
    editor.putString(NAMA, username);
    editor.apply();
}

public static String getLoggedInUser(Context context){
    return  getSharedPreference(context).getString(NAMA, "");
}

}
