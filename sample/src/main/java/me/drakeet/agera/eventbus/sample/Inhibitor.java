package me.drakeet.agera.eventbus.sample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import me.drakeet.agera.eventbus.AgeraBus;

/**
 * Created by drakeet on 16/6/13.
 */
public class Inhibitor extends IntentService {

    private final static String TAG = "Inhibitor";

    private static final String UPDATE = "me.drakeet.Inhibitor.update";


    public Inhibitor() {
        super(TAG);
    }


    @Override protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "呵呵, 我起来了");
        if (AgeraBus.repository().hasObservers()) {
            AgeraBus.repository().accept(new StringEvent(UPDATE));
            Log.d(TAG, "hasObservers = true");
        } else {
            // Save the event
            Log.d(TAG, "hasObservers = false");
        }
    }
}


