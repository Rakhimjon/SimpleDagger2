package uz.showme.simpledagger2.utils.rx;

import rx.Scheduler;

/**
 * Created by root on 3/10/18.
 */

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
