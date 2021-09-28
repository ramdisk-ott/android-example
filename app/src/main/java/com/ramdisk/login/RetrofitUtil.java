package com.ramdisk.login;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ramdisk.login.city.Cities;
import com.ramdisk.login.store.Store;
import com.ramdisk.login.uom.UOM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public class RetrofitUtil {
    private static String TAG = "RetrofitUtil";
    private static RetrofitUtil retrofitUtil;
    public static Context context;
    public static NetworkService networkService;

    public static synchronized RetrofitUtil getInstance() {
        if (retrofitUtil == null) {
            if (context == null) {
                return null;
            } else {
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

                httpClient.addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", "Bearer "); // <-- this is the important line
                    Request request = requestBuilder.build();
                    Log.d(TAG, "*****-----***** ");
                    Log.d(TAG, "url: " + request.url().toString());
                    Log.d(TAG, "header: " + request.headers().toString());
                    final Buffer buffer = new Buffer();
                    if (request.body() != null) {
                        request.body().writeTo(buffer);
                        Log.d(TAG, "body: " + buffer.readUtf8());
                    }
                    okhttp3.Response response = chain.proceed(request);
                    Log.d(TAG, "response: " + response.peekBody(2048).string());
                    return response;
                });

                OkHttpClient client = httpClient.connectTimeout(100, TimeUnit.SECONDS)
                        .readTimeout(100, TimeUnit.SECONDS).build();
                retrofitUtil = new RetrofitUtil();
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .create();
                Retrofit retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl("https://staging.skyvideo.in:8445/quinta-api/")
                        .addConverterFactory(GsonConverterFactory.create(gson)).client(client)
                        .build();
                networkService = retrofit.create(NetworkService.class);
            }
        }
        return retrofitUtil;
    }

    public interface NetworkService {
        @Headers({"Content-type: application/json"})
        @GET("weight_unit/10")
        Call<List<UOM>> uoms();

        @Headers({"Content-type: application/json"})
        @GET("city/list")
        Call<List<Cities>> cities();

        @Headers({"Content-type: application/json"})
        @GET("store/list")
        Call<List<Store>> store();
    }

}

