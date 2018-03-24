package uz.showme.simpledagger2.screen.detalis.heroes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

import javax.inject.Inject;

import uz.showme.simpledagger2.application.AppController;
import uz.showme.simpledagger2.models.Hero;
import uz.showme.simpledagger2.screen.detalis.HeroDetailsActivity;
import uz.showme.simpledagger2.screen.detalis.heroes.core.HeroesPresenter;
import uz.showme.simpledagger2.screen.detalis.heroes.core.HeroesView;
import uz.showme.simpledagger2.screen.detalis.heroes.dagger.DaggerHereosComponent;
import uz.showme.simpledagger2.screen.detalis.heroes.dagger.HeroesModule;

public class HeroesListActivity extends AppCompatActivity {
    @Inject
    HeroesView view;
    @Inject
    HeroesPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerHereosComponent.builder().appComponent(AppController.getNetComponent())
                .heroesModule(new HeroesModule(this)).build().inject(this);
        setContentView(view.view());
        presenter.onCreate();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void goToHeroDetailsActivity(Hero hero) {

        Intent in = new Intent(this, HeroDetailsActivity.class);
        in.putExtra("hero", (Serializable) hero);
        startActivity(in);

    }
}
