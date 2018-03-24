package uz.showme.simpledagger2.application.builder;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uz.showme.simpledagger2.utils.rx.AppRxSchedulers;

/**
 * Created by root on 3/10/18.
 */

@Module
public class NetworkModule {

    @AppScope
    @Provides
    OkHttpClient provideHttpClient(HttpLoggingInterceptor interceptor, Cache cache) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor).cache(cache);
        return builder.build();

    }
    @AppScope
    @Provides
    HttpLoggingInterceptor provideInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;

    }

    @AppScope
    @Provides
    File provideCacheFile(Context context){
        return context.getFilesDir();

    }
    @AppScope
    @Provides
    Cache provideCache(File file){
        return  new Cache(file, 10* 10 *1000);

    }

    @AppScope
    @Provides
    RxJavaCallAdapterFactory provideRxAdapter(){
        return RxJavaCallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS);
    }
    @Provides
    GsonConverterFactory provideGsonClient(){
        return GsonConverterFactory.create();
    }
}
