package com.example.src.smartpantry;

import android.util.Log;

import okhttp3.internal.connection.RouteException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BaseUrl="http://192.168.0.7/ok/";
    //"http://192.168.0.7/bookstore/";  192.168.43.25  http://192.168.0.7/bookstore/docregister.php
    //"http://192.168.0.136/bookstore/";  http://10.0.2.2/
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient() {

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        catch (RouteException e)
        {
            Log.e("",""+e.getMessage());
        }
        Log.e("","++++"+retrofit.toString());
        return retrofit;
    }
}
