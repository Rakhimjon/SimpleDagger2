package uz.showme.simpledagger2.screen.detalis.dagger;

import dagger.Component;
import uz.showme.simpledagger2.screen.detalis.HeroDetailsActivity;

/**
 * Created by root on 3/10/18.
 */
@Component(modules = {HeroDetailsModule.class})

public interface HeroDetailsComponent {
    void inject(HeroDetailsActivity context);
}
