package com.h5190036.yunus_emre_samat_final.network;

import com.h5190036.yunus_emre_samat_final.util.ConstantsJavaClass;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceJavaClass {

    private static Retrofit retrofit;
    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ConstantsJavaClass.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    static OkHttpClient okHttpClient;
    private static OkHttpClient getOkHttpClient()
    {
        if(okHttpClient == null) {
            okHttpClient =  new OkHttpClient().newBuilder().build();
        }

        return okHttpClient;
    }

    ServiceApiJavaInterface serviceApi;
    public ServiceApiJavaInterface getServiceApi() {

        if(serviceApi == null) {
            serviceApi = getRetrofit().create(ServiceApiJavaInterface.class);
        }

        return serviceApi;
    }

}