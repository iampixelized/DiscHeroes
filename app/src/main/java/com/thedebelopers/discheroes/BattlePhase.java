package com.thedebelopers.discheroes;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class BattlePhase extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_battle);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t1 = (TextView) findViewById(R.id.hero1);
        t2 = (TextView) findViewById(R.id.hero2);
        t3 = (TextView) findViewById(R.id.hp1);
        t4 = (TextView) findViewById(R.id.atk1);
        t5 = (TextView) findViewById(R.id.def1);
        t6 = (TextView) findViewById(R.id.hp2);
        t7 = (TextView) findViewById(R.id.atk2);
        t8 = (TextView) findViewById(R.id.def2);
        t9 = (TextView) findViewById(R.id.verbose);
        t10 = (TextView) findViewById(R.id.able1);
        t11 = (TextView) findViewById(R.id.able2);
        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");
        t1.setTypeface(ampersand);
        t2.setTypeface(ampersand);
        t3.setTypeface(ampersand);
        t4.setTypeface(ampersand);
        t5.setTypeface(ampersand);
        t6.setTypeface(ampersand);
        t7.setTypeface(ampersand);
        t8.setTypeface(ampersand);
        t9.setTypeface(ampersand);
        t10.setTypeface(ampersand);
        t11.setTypeface(ampersand);

        MediaPlayer bgm = MediaPlayer.create(getApplicationContext(), R.raw.mus_battle2);
        bgm.setVolume(0.75f, 0.75f);
        bgm.setLooping(true);
        bgm.start();

    }
}
