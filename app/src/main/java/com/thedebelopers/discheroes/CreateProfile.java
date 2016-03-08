package com.thedebelopers.discheroes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Eli on 2/14/2016.
 */
public class CreateProfile extends Activity {

    public EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_create);

        user = (EditText) findViewById(R.id.userinput);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .5), (int) (height * .3));

        //MediaPlayer bgm = MediaPlayer.create(getApplicationContext(),R.raw.music_main);
        //bgm.setLooping(true);
        //bgm.setVolume(0.75f,0.75f);
        //bgm.start();

        TextView tb, cb;
        tb = (TextView) findViewById(R.id.userinput);
        cb = (TextView) findViewById(R.id.createbutton);
        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");
        tb.setTypeface(ampersand);
        cb.setTypeface(ampersand);

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
        /* Button cr = (Button) findViewById(R.id.cancel);

        cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                startActivity(new Intent(CreateProfile.this, MainActivity.class));

            }
        }); */


    public void creP (View view) {
        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.pause();
            MainActivity.pos = MainActivity.bgm.getCurrentPosition();
            MainActivity.bgm.stop();
        }
        //String useryah = user.getText().toString();
        Intent test = new Intent(this, MainMenu.class);
        startActivity(test);
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

