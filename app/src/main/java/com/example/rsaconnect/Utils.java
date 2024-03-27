package com.example.rsaconnect;

import android.content.Context;

import com.example.rsaconnect.RSADatabase.ServiceProviderDB;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<ServiceProvider> getAllProviders(Context context){
        return (ArrayList<ServiceProvider>) ServiceProviderDB.getInstance(context).serviceProviderDao().getAllProvider();
    }
}
