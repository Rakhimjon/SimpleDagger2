package uz.showme.simpledagger2.application.builder;

import dagger.Module;
import dagger.Provides;
import uz.showme.simpledagger2.utils.rx.AppRxSchedulers;
import uz.showme.simpledagger2.utils.rx.RxSchedulers;

/**
 * Created by root on 3/10/18.
 */
@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedullers() {
        return new AppRxSchedulers();
    }


}
