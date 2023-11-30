package com.dario.ecorecicla.modelos;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;

import java.util.prefs.Preferences;

public class Herramientas {

    public static void logpy(String texto) {
        Log.i("puki", texto);

    }

    public static String getSharedUser(Context context) {
        String user;
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(context);
        user = preferencias.getString("user", "");
        return user;
    }

    public static boolean getLoginStatus(Context context) {
        // se genera el objeto preferencias de tipo shared preferences
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(context);
        // se obtiene el boleano del boton que esta en ajustes xml
        Boolean loginStatus = preferencias.getBoolean("Log Out status", false);
        return loginStatus;
    }

    public static void editPreferences(Context context, String user, Boolean status) {
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = preferencias.edit();
        editor.putBoolean("Log Out status", status);
        editor.putString("user", user);
        editor.apply();

        SharedPreferences preferencesUser = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        preferencesUser.edit().putString("user",user).apply();

    }

    public static void setPreferenceUserIcon(Context context) {
        String usuario = PreferenceManager.getDefaultSharedPreferencesName(context);
        logpy("las preferencias son "+usuario);
    }
}