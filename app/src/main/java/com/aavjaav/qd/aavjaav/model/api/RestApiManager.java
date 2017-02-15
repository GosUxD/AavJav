package com.aavjaav.qd.aavjaav.model.api;

import com.aavjaav.qd.aavjaav.model.utils.Constants;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiManager {

    LoginApi mLoginApi;
    RegisterApi mRegisterApi;

    public LoginApi getLoginApi() {
        if(mLoginApi == null) {
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(loggingInterceptor);

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(clientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .build();

            mLoginApi = client.create(LoginApi.class);
        }
        return mLoginApi;
    }

    public RegisterApi getRegisterApi() {
        if(mRegisterApi == null) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .build();

            mRegisterApi = client.create(RegisterApi.class);
        }
        return mRegisterApi;
    }

}
