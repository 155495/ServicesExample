package com.bivin.servicesexample;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by bivin on 3/22/2018.
 */

public class BackgroundServices extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.song);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
