package uz.showme.simpledagger2.screen.detalis.splash.dagger;

import dagger.Module;
import dagger.Provides;
import uz.showme.simpledagger2.screen.detalis.splash.SplashScreenActivity;

/**
 * Created by root on 3/10/18.
 */
@Module
public class SplashContextModule {
    SplashScreenActivity splashContext;
    public SplashContextModule(SplashScreenActivity context) {
        this.splashContext = context;
    }
    @SplashScope
    @Provides
    SplashScreenActivity provideSplashContext() {
        return splashContext;
    }
}
