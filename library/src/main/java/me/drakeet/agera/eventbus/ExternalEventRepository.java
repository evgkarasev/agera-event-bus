package me.drakeet.agera.eventbus;

import com.google.android.agera.MutableRepository;

/**
 * @author drakeet
 */
public interface ExternalEventRepository extends MutableRepository<Object> {

    boolean hasObservers();
}
