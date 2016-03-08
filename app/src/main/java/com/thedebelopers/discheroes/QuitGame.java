package com.thedebelopers.discheroes;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class QuitGame extends AppCompatActivity {
    /*private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }*/

    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        super.setFinishOnTouchOutside(finish);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_quit);

        //Intent music = new Intent();
        //music.setClass(this, MusicService.class);
        //startService(music);

        //mServ.resumeMusic();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .5), (int) (height * .3 ));

        TextView tb, cb, db;
        tb = (TextView) findViewById(R.id.textView);
        cb = (TextView) findViewById(R.id.confirm);
        db = (TextView) findViewById(R.id.deny);
        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");
        tb.setTypeface(ampersand);
        cb.setTypeface(ampersand);
        db.setTypeface(ampersand);

        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.pause();
            MainActivity.pos = MainActivity.bgm.getCurrentPosition();
            MainActivity.bgm.stop();
        }
        if (MainActivity.bgm.isPlaying()==false){
            MainActivity.bgm = MediaPlayer.create(getApplicationContext(), R.raw.mus_menu1);
            MainActivity.bgm.setLooping(true);
            MainActivity.bgm.seekTo(MainActivity.pos);
            MainActivity.bgm.start();
        }
    }

    public void bye (View view) {
        //mServ.stopMusic();
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.book_close);
        mp.start();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                MainActivity.bgm.stop();
                MainActivity.bgm.release();
                MainActivity.bgm = null;
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                /*moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);*/

            }
        }, 800);

    }

   public void back (View view) {
       if (MainActivity.bgm.isPlaying()) {
           MainActivity.bgm.pause();
           MainActivity.pos = MainActivity.bgm.getCurrentPosition();
           MainActivity.bgm.stop();
       }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        finish();
    }

    public void onBackPressed() {
        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.pause();
            MainActivity.pos = MainActivity.bgm.getCurrentPosition();
            MainActivity.bgm.stop();
        }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.book_flip);
        mp.start();

        finish();
    }
}
