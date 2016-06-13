package me.drakeet.agera.eventbus.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by drakeet on 16/6/13.
 */
public class KeepAliveReceiver extends BroadcastReceiver {

    @Override public void onReceive(Context context, Intent intent) {
        Intent restart = new Intent(context, Inhibitor.class);
        context.startService(restart);
    }
}
