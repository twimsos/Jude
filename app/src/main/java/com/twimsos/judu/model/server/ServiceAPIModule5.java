package com.twimsos.judu.model.server;


import com.jude.utils.JActivityManager;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceAPIModule5 {
    @Singleton
    @Provides
    ServiceAPI5 provideServiceAPI(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ServiceAPI5.URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(ServiceAPI5.class);
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        //设置缓存路径
       //File httpCacheDirectory = new File(JActivityManager.currentActivity().getCacheDir(), "responses");
        //设置缓存 30M
       //Cache cache = new Cache(httpCacheDirectory, 30 * 1024 * 1024);
        return new OkHttpClient.Builder()
                /*.cache(cache)
                .addNetworkInterceptor(new CacheInterceptor())*/
                .addNetworkInterceptor(new HeaderInterceptors())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                //.addNetworkInterceptor(new RestInterceptors2())
                .build();
    }

}
