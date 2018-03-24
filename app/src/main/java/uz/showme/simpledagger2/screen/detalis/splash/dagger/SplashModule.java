package uz.showme.simpledagger2.screen.detalis.splash.dagger;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;
import uz.showme.simpledagger2.api.HeroApi;
import uz.showme.simpledagger2.screen.detalis.splash.SplashScreenActivity;
import uz.showme.simpledagger2.screen.detalis.splash.core.SplashModel;
import uz.showme.simpledagger2.screen.detalis.splash.core.SplashPresenter;
import uz.showme.simpledagger2.screen.detalis.splash.core.SplashView;
import uz.showme.simpledagger2.utils.rx.RxSchedulers;

/**
 * Created by root on 3/10/18.
 */
@Module
public class SplashModule {

    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers, SplashModel model){
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new SplashPresenter(model, schedulers, compositeSubscription);
    }
    @SplashScope
    @Provides
    SplashView provideSplash(SplashScreenActivity context){
        return  new SplashView(context);

    }
    @SplashScope
    @Provides
    SplashModel provideSplashModel(HeroApi api, SplashScreenActivity contex){
        return  new SplashModel(api,contex);

    }
}
