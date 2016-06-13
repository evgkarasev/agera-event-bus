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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
