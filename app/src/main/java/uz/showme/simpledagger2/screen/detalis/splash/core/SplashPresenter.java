package uz.showme.simpledagger2.screen.detalis.splash.core;

import android.util.Log;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import uz.showme.simpledagger2.utils.UiUtils;
import uz.showme.simpledagger2.utils.rx.RxSchedulers;

/**
 * Created by root on 3/10/18.
 */

public class SplashPresenter {

    private SplashModel model;
    private RxSchedulers rxSchedulers;
    private CompositeSubscription subscriptions;

    public SplashPresenter(SplashModel model, RxSchedulers rxSchedulers, CompositeSubscription subscriptions) {
        this.model = model;
        this.rxSchedulers = rxSchedulers;
        this.subscriptions = subscriptions;
    }

    public void onCreate() {
        subscriptions.add(getHeroesList());
    }

    public void onDestroy() {
        subscriptions.clear();
    }

    private Subscription getHeroesList() {

        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.isNetworkAvailable()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread())
                .subscribe(aBoolean -> model.gotoHeroesListActivity(),
                        throwable -> UiUtils.handleThrowable(throwable));
    }
}
