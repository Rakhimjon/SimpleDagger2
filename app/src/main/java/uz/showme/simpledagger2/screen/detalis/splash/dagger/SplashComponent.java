package uz.showme.simpledagger2.screen.detalis.splash.dagger;

import dagger.Component;
import uz.showme.simpledagger2.application.builder.AppComponent;
import uz.showme.simpledagger2.screen.detalis.splash.SplashScreenActivity;

/**
 * Created by root on 3/10/18.
 */
@SplashScope
@Component(modules = {SplashContextModule.class, SplashModule.class}, dependencies = {AppComponent.class})
public interface SplashComponent {
    void inject(SplashScreenActivity activity);
}
