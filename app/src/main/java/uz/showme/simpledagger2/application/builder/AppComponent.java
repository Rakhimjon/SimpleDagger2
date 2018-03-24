package uz.showme.simpledagger2.application.builder;

import dagger.Component;
import uz.showme.simpledagger2.api.HeroApi;
import uz.showme.simpledagger2.utils.rx.RxSchedulers;

/**
 * Created by root on 3/10/18.
 */
@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, HereosApiServiceModule.class})
public interface AppComponent {
    RxSchedulers rxShedullers();
    HeroApi apiService();


}
