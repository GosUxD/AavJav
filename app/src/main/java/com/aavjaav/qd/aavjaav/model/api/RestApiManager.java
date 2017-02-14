package com.aavjaav.qd.aavjaav.model.api;

import com.aavjaav.qd.aavjaav.model.utils.Constants;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiManager {

    LoginApi mLoginApi;

    public LoginApi getLoginApi() {
        if(mLoginApi == null) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .build();

            mLoginApi = client.create(LoginApi.class);
        }
        return mLoginApi;
    }

}
