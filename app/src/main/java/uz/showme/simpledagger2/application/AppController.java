package uz.showme.simpledagger2.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;
import uz.showme.simpledagger2.BuildConfig;
import uz.showme.simpledagger2.application.builder.AppComponent;
import uz.showme.simpledagger2.application.builder.AppContextModule;
import uz.showme.simpledagger2.application.builder.DaggerAppComponent;

/**
 * Created by root on 3/10/18.
 */

public class AppController extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);

    }
    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appContextModule(new AppContextModule(this)).build();
    }

    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }
    public static AppComponent getNetComponent() {
        return appComponent;
    }
}
