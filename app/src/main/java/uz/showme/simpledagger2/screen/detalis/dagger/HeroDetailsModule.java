package uz.showme.simpledagger2.screen.detalis.dagger;

import dagger.Module;
import dagger.Provides;
import uz.showme.simpledagger2.models.Hero;
import uz.showme.simpledagger2.screen.detalis.HeroDetailsActivity;
import uz.showme.simpledagger2.screen.detalis.HeroDetailsView;

/**
 * Created by root on 3/10/18.
 */
@Module
public class HeroDetailsModule {
    HeroDetailsActivity detailsContext;
    Hero hero;

    public HeroDetailsModule(HeroDetailsActivity detailsContext, Hero hero) {
        this.detailsContext = detailsContext;
        this.hero = hero;
    }

    @Provides
    HeroDetailsView view(){
        return new HeroDetailsView(detailsContext, hero);
    }

}
