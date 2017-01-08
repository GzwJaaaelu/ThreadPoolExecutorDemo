package com.jaaaelu.gzw.threadpoolexecutordemo.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "http://gank.io/api/";
    public static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    private static volatile RetrofitClient singleton;
    private final Retrofit mRetrofit;

    private RetrofitClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .connectTimeout(5000, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    public static RetrofitClient getInstance() {
        if (singleton == null) {
            synchronized (RetrofitClient.class) {
                if (singleton == null) {
                    singleton = new RetrofitClient();
                }
            }
        }
        return singleton;
    }

    public ApiManager getApiManager() {
        return mRetrofit.create(ApiManager.class);
    }

}