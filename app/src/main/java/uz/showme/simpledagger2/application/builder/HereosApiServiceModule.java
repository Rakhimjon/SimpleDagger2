package uz.showme.simpledagger2.application.builder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uz.showme.simpledagger2.api.HeroApi;

/**
 * Created by root on 3/10/18.
 */
@Module
public class HereosApiServiceModule {
    private static final String BASE_URL = "http://coemygroup.fr/";

    @AppScope
    @Provides
    HeroApi provideApiService(OkHttpClient client, GsonConverterFactory gson,
                              RxJavaCallAdapterFactory rxAdapter){

        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter).build();

        return retrofit.create(HeroApi.class);
    }
}
