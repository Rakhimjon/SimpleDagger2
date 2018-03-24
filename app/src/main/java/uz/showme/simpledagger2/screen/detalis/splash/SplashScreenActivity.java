package uz.showme.simpledagger2.screen.detalis.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import uz.showme.simpledagger2.application.AppController;
import uz.showme.simpledagger2.screen.detalis.heroes.HeroesListActivity;
import uz.showme.simpledagger2.screen.detalis.splash.core.SplashPresenter;
import uz.showme.simpledagger2.screen.detalis.splash.core.SplashView;
import uz.showme.simpledagger2.screen.detalis.splash.dagger.DaggerSplashComponent;
import uz.showme.simpledagger2.screen.detalis.splash.dagger.SplashContextModule;

public class SplashScreenActivity extends AppCompatActivity {


    @Inject
    SplashView view;
    @Inject
    SplashPresenter splashPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSplashComponent.builder().
                appComponent(AppController.getNetComponent()).
                splashContextModule(new SplashContextModule(this)).
                build().inject(this);

        setContentView(view.constructView());
        splashPresenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.onDestroy();
    }

    public void showHeroesListActivity() {
        Log.d("loaded", "ok showed");
        Intent i = new Intent(this, HeroesListActivity.class);
        startActivity(i);
    }
}
