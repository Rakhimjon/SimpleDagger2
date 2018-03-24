package uz.showme.simpledagger2.screen.detalis.heroes.core;

import android.util.Log;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import uz.showme.simpledagger2.models.Hero;
import uz.showme.simpledagger2.utils.UiUtils;
import uz.showme.simpledagger2.utils.rx.RxSchedulers;

/**
 * Created by root on 3/10/18.
 */

public class HeroesPresenter {
    HeroesView view;
    HeroesModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    ArrayList<Hero> heros = new ArrayList<>();

    public HeroesPresenter(RxSchedulers schedulers, HeroesModel model, HeroesView view, CompositeSubscription sub) {
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscriptions = sub;
    }

    public void onCreate(){
        Log.d("enter to presenter", "oki");
        subscriptions.add(getHeroesList());
        subscriptions.add(respondToClick());
    }
    public void onDestroy() {
        subscriptions.clear();
    }
    private Subscription respondToClick() {

        return view.itemClicks().subscribe(integer -> model.gotoHeroDetailsActivity(heros.get(integer)));
    }

    private Subscription getHeroesList(){
        return model.isNetworkAvialable().doOnNext(networkAvailable->{
            if (!networkAvailable){
                Log.v("no conn","No connection");

            }
        }).
                filter(isNetworkAvialable-> true)
                .flatMap(isAvailable->model.provideListHeroes())
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread()).subscribe(heroes -> {
                    Log.v("ok loaded", "ccc");
                    view.swapAdapter((ArrayList<Hero>) heroes.getElements());
                    heros = (ArrayList<Hero>) heroes.getElements();
                }, UiUtils::handleThrowable);
    }
}
