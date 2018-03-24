package uz.showme.simpledagger2.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 3/10/18.
 */
@Module
public class AppContextModule {
    private  final Context context;

    public AppContextModule(Context context) {
        this.context = context;
    }

    @AppScope
    @Provides
    Context provideAppContext(){
        return context;
    }
}
