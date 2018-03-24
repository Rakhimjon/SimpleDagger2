package uz.showme.simpledagger2.screen.detalis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import uz.showme.simpledagger2.models.Hero;
import uz.showme.simpledagger2.screen.detalis.dagger.DaggerHeroDetailsComponent;
import uz.showme.simpledagger2.screen.detalis.dagger.HeroDetailsModule;

public class HeroDetailsActivity extends AppCompatActivity {

    @Inject
    HeroDetailsView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Hero hero =(Hero)getIntent().getExtras().get("hero");
        DaggerHeroDetailsComponent.builder()
                .heroDetailsModule(new HeroDetailsModule(this,hero))
                .build().inject(this);


        setContentView(view.view());
    }
}
