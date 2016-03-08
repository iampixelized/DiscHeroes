package com.thedebelopers.discheroes;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryMenu extends AppCompatActivity {

    public static int nosepick;
    public static String hero1;
    String []team1;
    public static String hero2;
    String []team2;

    TextView des, ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, pl, mm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.menu_story);

        des= (TextView) findViewById(R.id.desc);
        ch1= (TextView) findViewById(R.id.c1);
        ch2= (TextView) findViewById(R.id.c2);
        ch3= (TextView) findViewById(R.id.c3);
        ch4= (TextView) findViewById(R.id.c4);
        ch5= (TextView) findViewById(R.id.c5);
        ch6= (TextView) findViewById(R.id.c6);
        ch7= (TextView) findViewById(R.id.c7);
        ch8= (TextView) findViewById(R.id.c8);
        ch9= (TextView) findViewById(R.id.c9);
        ch10= (TextView) findViewById(R.id.c10);
        pl= (TextView) findViewById(R.id.p);
        mm= (TextView) findViewById(R.id.m);

        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");

        des.setTypeface(ampersand);
        ch1.setTypeface(ampersand);
        ch2.setTypeface(ampersand);
        ch3.setTypeface(ampersand);
        ch4.setTypeface(ampersand);
        ch5.setTypeface(ampersand);
        ch6.setTypeface(ampersand);
        ch7.setTypeface(ampersand);
        ch8.setTypeface(ampersand);
        ch9.setTypeface(ampersand);
        ch10.setTypeface(ampersand);
        pl.setTypeface(ampersand);
        mm.setTypeface(ampersand);

        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.pause();
            MainActivity.pos = MainActivity.bgm.getCurrentPosition();
            MainActivity.bgm.stop();
        }
        if (MainActivity.bgm.isPlaying()==false){
            MainActivity.bgm = MediaPlayer.create(getApplicationContext(), R.raw.mus_menu6);
            MainActivity.bgm.setLooping(true);
            MainActivity.bgm.seekTo(MainActivity.pos);
            MainActivity.bgm.start();
        }
    }

    public void mm (View view) {
        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.pause();
            MainActivity.pos = MainActivity.bgm.getCurrentPosition();
            MainActivity.bgm.stop();
        }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        Intent test = new Intent(this, MainMenu.class);
        startActivity(test);
    }

    public void play (View view) {
        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.pause();
            MainActivity.pos = MainActivity.bgm.getCurrentPosition();
            MainActivity.bgm.stop();
        }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        if (nosepick == 1){
            hero1 = "pog1";
            team1 =new String[]{"1pog1"};
            hero2 = "pog0";
            team2 = new String[]{"2pog0"};

            Intent test = new Intent(this, CollectPhase.class);
            //Intent pop = new Intent(this, TutorialPop.class);
            test.putExtra("team1", team1);
            test.putExtra("team2", team2);
            startActivity(test);
            //startActivity(pop);
        }
        if (nosepick == 2){
            hero1 = "pog1";
            team1 =new String[]{"1pog1"};
            hero2 = "pog4";
            team2 = new String[]{"2pog4"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1", team1);
            test.putExtra("team2", team2);
            startActivity(test);
        }
        if (nosepick == 3){
            hero1 = "pog10";
            team1 =new String[]{"1pog4","1pog1","1pog1"};
            hero2 = "pog5";
            team2 = new String[]{"2pog4","2pog4","2pog4"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1",team1);
            test.putExtra("team2",team2);
            startActivity(test);
        }
        if (nosepick == 4) {
            hero1 = "pog11";
            team1 =new String[]{"1pog10","1pog4","1pog1","1pog1"};
            hero2 = "pog5";
            team2 = new String[]{"2pog5","2pog4","2pog4","2pog4"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1",team1);
            test.putExtra("team2",team2);
            startActivity(test);
        }
        if (nosepick == 5){
            hero1 = "pog12";
            team1 =new String[]{"1pog11","1pog10","1pog4","1pog1","1pog1"};
            hero2 = "pog9";
            team2 = new String[]{"2pog5","2pog5","2pog4","2pog4","2pog4"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1",team1);
            test.putExtra("team2",team2);
            startActivity(test);
        }
        if (nosepick == 6){
            hero1 = "pog13";
            team1 =new String[]{"1pog12","1pog11","1pog10","1pog4","1pog1","1pog1"};
            hero2 = "pog7";
            team2 = new String[]{"2pog7","2pog7","2pog7","2pog7","2pog7","2pog7"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1",team1);
            test.putExtra("team2",team2);
            startActivity(test);
        }
        if (nosepick == 7){
            hero1 = "pog14";
            team1 =new String[]{"1pog13","1pog12","1pog11","1pog10","1pog4","1pog1","1pog1"};
            hero2 = "pog8";
            team2 = new String[]{"2pog8","2pog8","2pog8","2pog8","2pog8","2pog8","2pog8"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1",team1);
            test.putExtra("team2",team2);
            startActivity(test);
        }
        if (nosepick == 8){
            hero1 = "pog15";
            team1 =new String[]{"1pog14","1pog13","1pog12","1pog11","1pog10","1pog4","1pog1","1pog1"};
            hero2 = "pog9";
            team2 = new String[]{"2pog8","2pog8","2pog8","2pog8","2pog7","2pog7","2pog7","2pog7"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1",team1);
            test.putExtra("team2",team2);
            startActivity(test);
        }
        if (nosepick == 9){
            hero1 = "pog2";
            team1 =new String[]{"1pog15","1pog14","1pog13","1pog12","1pog11","1pog10","1pog4","1pog1","1pog1"};
            hero2 = "pog17";
            team2 = new String[]{"2pog17","2pog17","2pog17","2pog17","2pog16","2pog16","2pog16","2pog16","2pog16"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1",team1);
            test.putExtra("team2",team2);
            startActivity(test);
        }
        if (nosepick == 10){
            hero1 = "pog3";
            team1 =new String[]{"1pog2","1pog15","1pog14","1pog13","1pog12","1pog11","1pog10","1pog4","1pog1","1pog1"};
            hero2 = "pog21";
            team2 = new String[]{"2pog20","2pog14","2pog11","2pog5","2pog19","2pog16","2pog13","2pog10","2pog4","2pog1"};

            Intent test = new Intent(this, CollectPhase.class);
            test.putExtra("team1",team1);
            test.putExtra("team2",team2);
            startActivity(test);
        }

    }

    public void likod (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Choose a Chapter");

        View b = findViewById(R.id.p);
        b.setVisibility(View.INVISIBLE);
        b.setClickable(false);

        View e =findViewById(R.id.likod);
        e.setClickable(false);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.INVISIBLE);

    }



    public void c1 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 1\n\nWelcome player to Discrea, we have a tournament that is going to be held soon, and you are invited. Here are twin flamelings for you to use and here are some dummies for target practice.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch1);

        nosepick = 1;
    }

    public void c2 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 2\n\nNow you know how to play you can now recruit more heroes. We found mushbros nearby, try to defeat them and they might join your team.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch2);

        nosepick = 2;
    }

    public void c3 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 3\n\nYour team is now growing, a mushbro joined your team. Here is a leafle as an achievement gift. We'll switch your team leader to leafle and battle this team of mushbrad.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch3);

        nosepick = 3;
    }

    public void c4 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 4\n\nYou defeated mushbrad an intermediate hero, too bad it did not join your team. The mushbrad wants a rematch and he brought one more teammate. We'll switch your team leader to seedshell.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch4);

        nosepick = 4;
    }

    public void c5 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 5\n\n2nd win against mushbrad and still didn't want to join you. You're good at this, here's an advanced hero as gift. Mushbrad brought an advanced hero and wants another rematch, we'll switch your leader to seedwing so that you can take him down again.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch5);

        nosepick = 5;
    }

    public void c6 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 6\n\nAfter watching your matches driplet wants you to help it defeat sparkies. If it defeated them it will make its former teammates join you, so yeah, we have to change your team leader to driplet. Sparkies are novice heroes so you can take them down easily.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch6);

        nosepick = 6;
    }

    public void c7 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 7\n\nAs a promise, angii wants to join you, an intermediate hero. Seems that the sparkies are not alone, sparkchops surrounded your team. Well be changing your teamleader to angii now.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch7);

        nosepick = 7;
    }

    public void c8 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 8\n\nGuitai joined your team, an advanced hero from diplet's former team. We spotted a rampaging hampere comming towards your team, it's an advanced hero so we'll be changing your team leader to guitai, so prepair yourself.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch8);

        nosepick = 8;
    }

    public void c9 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 9\n\nToursle, an itermediate hero wants to battle you, it brought it's teammates along. Blazelet was amazed by your skills in managing your team and now it wants to help you out, it is also an itermediate hero, let's switch your leader to blazelet then.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch9);

        nosepick = 9;
    }

    public void c10 (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        TextView test = (TextView)findViewById(R.id.desc);
        test.setText("Chapter 10\n\nThe tournament is one fight away. You have to defeat klatzinoir's team to be registered in the tournament. We have our last gift for you, it's an advanced hero, we'll be switching your hero to it, do your best and goodluck.");

        View b = findViewById(R.id.p);
        b.setVisibility(View.VISIBLE);
        b.setClickable(true);

        View e =findViewById(R.id.likod);
        e.setClickable(true);

        ImageView dib =(ImageView) findViewById(R.id.diba);
        dib.setVisibility(View.VISIBLE);
        dib.setImageResource(R.drawable.ch10);

        nosepick = 10;
    }

    public void onBackPressed(){
        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.pause();
            MainActivity.pos = MainActivity.bgm.getCurrentPosition();
            MainActivity.bgm.stop();
        }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        Intent test = new Intent(this, QuitGame.class);
        startActivity(test);

    }

}
