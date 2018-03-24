package uz.showme.simpledagger2.api;

import retrofit2.http.GET;
import rx.Observable;
import uz.showme.simpledagger2.models.Heroes;

/**
 * Created by root on 3/10/18.
 */

public interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    Observable<Heroes> getHeroes();

}
