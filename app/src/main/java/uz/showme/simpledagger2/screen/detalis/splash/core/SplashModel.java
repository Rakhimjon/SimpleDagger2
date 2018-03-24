package uz.showme.simpledagger2.screen.detalis.splash.core;

import rx.Observable;
import uz.showme.simpledagger2.api.HeroApi;
import uz.showme.simpledagger2.models.Heroes;
import uz.showme.simpledagger2.screen.detalis.splash.SplashScreenActivity;
import uz.showme.simpledagger2.utils.NetworkUtils;

/**
 * Created by root on 3/10/18.
 */

public class SplashModel {


    private HeroApi api;
    private SplashScreenActivity splashContext;

    public SplashModel(HeroApi api, SplashScreenActivity splashCtx) {
        this.api = api;
        this.splashContext = splashCtx;

    }

    Observable<Heroes> provideListHeroes() {
        return api.getHeroes();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(splashContext);
    }


    public void gotoHeroesListActivity() {
        splashContext.showHeroesListActivity();

    }

}
