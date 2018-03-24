package uz.showme.simpledagger2.screen.detalis.heroes.dagger;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;
import uz.showme.simpledagger2.api.HeroApi;
import uz.showme.simpledagger2.screen.detalis.heroes.HeroesListActivity;
import uz.showme.simpledagger2.screen.detalis.heroes.core.HeroesModel;
import uz.showme.simpledagger2.screen.detalis.heroes.core.HeroesPresenter;
import uz.showme.simpledagger2.screen.detalis.heroes.core.HeroesView;
import uz.showme.simpledagger2.utils.rx.RxSchedulers;

/**
 * Created by root on 3/10/18.
 */
@Module
public class HeroesModule {

    HeroesListActivity heroesListContext;

    public HeroesModule(HeroesListActivity context) {
        this.heroesListContext = context;
    }

    @HeroesScope
    @Provides
    HeroesView provideView() {
        return new HeroesView(heroesListContext);

    }

    @HeroesScope
    @Provides
    HeroesPresenter providePresenter(RxSchedulers schedulers, HeroesView view, HeroesModel model) {
        CompositeSubscription subscription = new CompositeSubscription();
        return new HeroesPresenter(schedulers, model, view, subscription);
    }

    @HeroesScope
    @Provides
    HeroesListActivity provideContext() {
        return heroesListContext;

    }

    @HeroesScope
    @Provides
    HeroesModel provideModel(HeroApi api) {
        return new HeroesModel(heroesListContext, api);

    }
}
