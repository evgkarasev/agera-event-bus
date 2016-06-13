/*
 * Copyright (C) 2016 drakeet.
 *      http://drakeet.me
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.drakeet.agera.eventbus;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.agera.ActivationHandler;
import com.google.android.agera.Observables;
import com.google.android.agera.Updatable;
import com.google.android.agera.UpdateDispatcher;

/**
 * @author drakeet
 */
public final class EventRepository implements ExternalEventRepository, ActivationHandler {

    private final static Object EMPTY = new Object();
    @NonNull
    private final UpdateDispatcher updateDispatcher;
    @Nullable
    private Object reference;
    private boolean hasObservers;


    public EventRepository() {
        this(null);
    }


    public EventRepository(@Nullable final Object reference) {
        this.updateDispatcher = Observables.updateDispatcher(this);
        this.reference = reference;
    }


    @NonNull @Override public synchronized Object get() {
        if (reference == null) {
            return EMPTY;
        }
        return reference;
    }


    /**
     * For checking the DeadEvent
     *
     * @return true, has observers, otherwise false
     */
    @Override public boolean hasObservers() {
        return hasObservers;
    }


    /**
     * Post an Event
     *
     * @param reference your Event
     */
    @Override public void accept(@NonNull final Object reference) {
        synchronized (this) {
            this.reference = reference;
        }
        updateDispatcher.update();
    }


    @Override public void addUpdatable(@NonNull final Updatable updatable) {
        updateDispatcher.addUpdatable(updatable);
    }


    @Override public void removeUpdatable(@NonNull final Updatable updatable) {
        updateDispatcher.removeUpdatable(updatable);
    }


    @Override public void observableActivated(@NonNull UpdateDispatcher caller) {
        hasObservers = true;
    }


    @Override public void observableDeactivated(@NonNull UpdateDispatcher caller) {
        hasObservers = false;
    }
}
