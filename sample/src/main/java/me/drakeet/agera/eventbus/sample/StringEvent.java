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
