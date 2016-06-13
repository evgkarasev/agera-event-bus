package me.drakeet.agera.eventbus;

import android.support.annotation.NonNull;

/**
 * @author drakeet
 */
public class AgeraBus {

    private AgeraBus() {
    }


    private static class LazyLoad {
        static final ExternalEventRepository bus = new EventRepository();
    }


    @NonNull public static ExternalEventRepository repository() {
        return LazyLoad.bus;
    }
}
