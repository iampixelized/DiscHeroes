package com.thedebelopers.discheroes;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class Shop extends AppCompatActivity {

    TextView b1, b2, b3, b4, b5, b6, b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MediaPlayer bgm = MediaPlayer.create(getApplicationContext(),R.raw.mus_temshop);
        bgm.setLooping(true);
        bgm.setVolume(0.75f, 0.75f);
        bgm.start();

        b1= (TextView) findViewById(R.id.credits);
        b2= (TextView) findViewById(R.id.tip);
        b3= (TextView) findViewById(R.id.price1);
        b4= (TextView) findViewById(R.id.price2);
        b5= (TextView) findViewById(R.id.price3);
        b6= (TextView) findViewById(R.id.inventory);
        b7= (TextView) findViewById(R.id.back);
        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");
        b1.setTypeface(ampersand);
        b2.setTypeface(ampersand);
        b3.setTypeface(ampersand);
        b4.setTypeface(ampersand);
        b5.setTypeface(ampersand);
        b6.setTypeface(ampersand);
        b7.setTypeface(ampersand);

    }

    public void onBackPressed(){

        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.stop();
        }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        Intent test = new Intent(this, ExtrasMenu.class);
        startActivity(test);

    }
}
