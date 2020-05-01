package com.apps.juanlazuardo.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.apps.juanlazuardo.model.UserModel;
import android.content.Context;
import android.content.SharedPreferences;
import com.apps.juanlazuardo.model.UserModel;
public class Preferences {
        private static final String PREF_SESSION = "com.apps.rizkiadam.latihansharedpreferences.session";
        private final static String REGISTER_USERNAME = "REGISTER_USERNAME";
        private final static String REGISTER_PASSWORD = "REGISTER_PASSWORD";
        private final static String REGISTER_PHONE = "REGISTER_PHONE";
        private final static String LOGIN_STATUS = "LOGIN_STATUS";



        private Context context;

        public Preferences(Context context) {
            this.context = context;
        }

        public static void setUserPreferences(Context context, UserModel userModel) {
            SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString(REGISTER_USERNAME, userModel.getUsername());
            editor.putString(REGISTER_PASSWORD, userModel.getPassword());
            editor.putString(REGISTER_PHONE, userModel.getPhone());
            editor.apply();
        }

        public static String getRegisteredUser(Context context) {
            SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
            return preferences.getString(REGISTER_USERNAME, Utils.DEFAULT_STRING);
        }

        public static String getRegisteredPassword(Context context) {
            SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
            return preferences.getString(REGISTER_PASSWORD, Utils.DEFAULT_STRING);
        }

        public static String getRegisteredPhone(Context context) {
            SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
            return preferences.getString(REGISTER_PHONE, Utils.DEFAULT_STRING);
        }

        /** Deklarasi Edit Preferences dan mengubah data
         *  yang memiliki key KEY_STATUS_SEDANG_LOGIN dengan parameter status */
        public static void setLoggedInStatus(Context context, boolean statusLogin) {
            SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putBoolean(LOGIN_STATUS, statusLogin);
            editor.apply();
        }

        public static boolean getLoggedInStatus(Context context) {
            SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
            return preferences.getBoolean(LOGIN_STATUS, Utils.DEFAULT_BOOLEAN);
        }


        public static void setLogout(Context context){
            SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(LOGIN_STATUS);
            editor.apply();
        }

    }


