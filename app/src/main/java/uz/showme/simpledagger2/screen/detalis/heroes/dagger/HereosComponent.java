package uz.showme.simpledagger2.screen.detalis.heroes.dagger;

import dagger.Component;
import uz.showme.simpledagger2.application.builder.AppComponent;
import uz.showme.simpledagger2.screen.detalis.heroes.HeroesListActivity;

/**
 * Created by root on 3/10/18.
 */
@HeroesScope
@Component(dependencies = {AppComponent.class},modules = {HeroesModule.class})
public interface HereosComponent {
    void inject(HeroesListActivity heroesActivity);
}
