package uz.showme.simpledagger2.screen.detalis.heroes.core;

import rx.Observable;
import uz.showme.simpledagger2.api.HeroApi;
import uz.showme.simpledagger2.models.Hero;
import uz.showme.simpledagger2.models.Heroes;
import uz.showme.simpledagger2.screen.detalis.heroes.HeroesListActivity;
import uz.showme.simpledagger2.utils.NetworkUtils;

/**
 * Created by root on 3/10/18.
 */

public class HeroesModel {
    HeroesListActivity context;
    HeroApi api;

    public HeroesModel(HeroesListActivity context, HeroApi api) {
        this.context = context;
        this.api = api;
    }
    Observable<Heroes> provideListHeroes(){
        return api.getHeroes();

    }
    Observable<Boolean> isNetworkAvialable(){
        return NetworkUtils.isNetworkAvailableObservable(context);
    }
    public  void  gotoHeroDetailsActivity(Hero hero){
        context.goToHeroDetailsActivity(hero);
    }
}
