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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.google.android.agera.Updatable;
import me.drakeet.agera.eventbus.AgeraBus;

public class MainActivity extends AppCompatActivity implements Updatable {

    private static final String TAG = "MainActivity";
    private TextView textView;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        AgeraBus.repository().addUpdatable(this);
    }


    @Override public void update() {
        if (AgeraBus.repository().get() instanceof StringEvent) {
            Log.d(TAG, "update");
            textView.setText("呵呵, 我起来了. (黑月亮脸)");
        }
    }


    @Override protected void onDestroy() {
        super.onDestroy();
        AgeraBus.repository().removeUpdatable(this);
    }
}
