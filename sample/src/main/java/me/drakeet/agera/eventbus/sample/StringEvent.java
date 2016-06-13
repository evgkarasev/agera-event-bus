package me.drakeet.agera.eventbus.sample;

import android.support.annotation.NonNull;
import com.google.android.agera.Preconditions;
import com.google.android.agera.Supplier;

/**
 * Created by drakeet on 16/6/13.
 */

public class StringEvent implements Supplier<String> {

    @NonNull public final String value;


    public StringEvent(@NonNull String value) {
        this.value = Preconditions.checkNotNull(value);
    }


    @NonNull @Override public String get() {
        return value;
    }
}
