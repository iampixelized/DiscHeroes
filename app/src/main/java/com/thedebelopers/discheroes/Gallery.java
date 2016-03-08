package com.thedebelopers.discheroes;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Gallery extends AppCompatActivity {

    TextView b1, b2, b3, b4, b5, b6;
    public int count1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MediaPlayer bgm = MediaPlayer.create(getApplicationContext(), R.raw.mus_temvillage);
        bgm.setVolume(0.75f,0.75f);
        bgm.setLooping(true);
        bgm.start();

        View pr = findViewById(R.id.previous);
        View ne = findViewById(R.id.next);
        b1= (TextView) findViewById(R.id.nameView);
        b2= (TextView) findViewById(R.id.statView);
        b3= (TextView) findViewById(R.id.triviaView);
        b4= (TextView) pr;
        b5= (TextView) ne;
        b6= (TextView) findViewById(R.id.back);
        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");
        b1.setTypeface(ampersand);
        b2.setTypeface(ampersand);
        b3.setTypeface(ampersand);
        b4.setTypeface(ampersand);
        b5.setTypeface(ampersand);
        b6.setTypeface(ampersand);

        /*if (count1==0){
            pr.setVisibility(View.INVISIBLE);
            pr.setClickable(false);
            ne.setVisibility(View.VISIBLE);
            ne.setClickable(true);
            TextView test = (TextView)findViewById(R.id.nameView);
            test.setText("001 - FLAMELING");
        }else if (count1==1){
            pr.setVisibility(View.VISIBLE);
            pr.setClickable(true);
            ne.setVisibility(View.INVISIBLE);
            ne.setClickable(false);
            TextView test = (TextView)findViewById(R.id.nameView);
            test.setText("002 - BLAZELET");
        }*/


        /*
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1 -= 1;
            }
        });

        ne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1 += 1;
            }
        });*/
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void p (View view) {

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        count1-=1;
        TextView heroname = (TextView) findViewById(R.id.nameView);
        TextView herostat = (TextView) findViewById(R.id.statView);
        TextView herodesc = (TextView) findViewById(R.id.triviaView);
        ImageView hero = (ImageView) findViewById(R.id.spriteView);
        Button pr = (Button) findViewById(R.id.previous);
        Button ne = (Button) findViewById(R.id.next);

        switch (count1) {
            case 1:
                pr.setVisibility(View.INVISIBLE);
                pr.setClickable(false);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite001);
                hero.setScaleX(1);
                heroname.setText("001 - FLAMELING");
                herostat.setText("hp: 20   atk: 5   def: 3   spd: 5\nability: enemy&apos;s hp -10");
                herodesc.setText("Flamelings live in nearby swamps deep in forests.");
                break;
            case 2:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite002);
                hero.setScaleX(-1);
                heroname.setText("002 - BLAZELET");
                herostat.setText("hp: 30   atk: 8   def: 5   spd: 8\nability: hero&apos;s hp +10");
                herodesc.setText("Blazelet stands still for a long time to conserve energy.");
                break;
            case 3:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite003);
                hero.setScaleX(1);
                heroname.setText("003 - BLAZEKRIEG");
                herostat.setText("hp: 53   atk: 14   def: 9   spd: 14\nability: hero&apos;s attack +5");
                herodesc.setText("Blazekriegs are said to be reborn into flamelings upon death.");
                break;
            case 4:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite004);
                hero.setScaleX(-1);
                heroname.setText("004 - MUSHBRO");
                herostat.setText("hp: 21   atk: 4   def: 4   spd: 3\nability: hero&apos;s defense +1");
                herodesc.setText("Wether a mushbro is happy or not their facial expression does not change.");
                break;
            case 5:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite005);
                hero.setScaleX(1);
                heroname.setText("005 - MUSHBRAD");
                herostat.setText("hp: 32   atk: 6   def: 6   spd: 5\nability: hero&apos;s defense +2");
                herodesc.setText("They would stumble often and they struggle in getting up.");
                break;
            case 6:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite006);
                hero.setScaleX(-1);
                heroname.setText("006 - MUSHBOSS");
                herostat.setText("hp: 56   atk: 11   def: 11   spd: 9\nability: hero&apos;s defense +5");
                herodesc.setText("Despite of their intimidating size they prefer using their minds than brute force.");
                break;
            case 7:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite007);
                hero.setScaleX(1);
                heroname.setText("007 - SPARKIE");
                herostat.setText("hp: 19   atk: 6   def: 3   spd: 7\nability: hero&apos;s attack +1");
                herodesc.setText("Sparkies can climb walls. The metallic ball like part at the tip of their tail stores electricity.");
                break;
            case 8:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite008);
                hero.setScaleX(-1);
                heroname.setText("008 - SPARCHOP");
                herostat.setText("hp: 29   atk: 9   def: 5   spd: 11\nability: hero&apos;s attack +2");
                herodesc.setText("Their snout can discharge electricity. During discharge they sometimes float a little bit.");
                break;
            case 9:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite009);
                hero.setScaleX(1);
                heroname.setText("009 - HAMPERE");
                herostat.setText("hp: 52   atk: 16   def: 9   spd: 19\nability: hero&apos;s attack +5");
                herodesc.setText("Unlike sparkies and sparkchops, hamperes can't climb walls due to their weight.");
                break;
            case 10:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite010);
                hero.setScaleX(-1);
                heroname.setText("010 - LEAFLE");
                herostat.setText("hp: 22   atk: 5   def: 3   spd: 4\nability: enemy&apos;s defense -1");
                herodesc.setText("The leaf at the tip of their tail can cut through branches.");
                break;
            case 11:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite011);
                hero.setScaleX(1);
                heroname.setText("011 - SEEDSHELL");
                herostat.setText("hp: 33   atk: 8   def: 5   spd: 6\nability: enemy&apos;s defense -2");
                herodesc.setText("The shell covering their fists can act as a weapon and a shield.");
                break;
            case 12:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite012);
                hero.setScaleX(-1);
                heroname.setText("012 - SEEDWING");
                herostat.setText("hp: 58   atk: 14   def: 9   spd: 11\nability: enemy&apos;s defense -5");
                herodesc.setText("They store energy from sunlight, enough energy for them to keep flying more than a day.");
                break;
            case 13:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite013);
                hero.setScaleX(1);
                heroname.setText("013 - DRIPLET");
                herostat.setText("hp: 21   atk: 4   def: 3   spd: 4\nability: hero&apos;s hp +5");
                herodesc.setText("They are warm but always wet. It is impossible to make driplets dry.");
                break;
            case 14:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite014);
                hero.setScaleX(-1);
                heroname.setText("014 - ANGII");
                herostat.setText("hp: 32   atk: 6   def: 5   spd: 6\nability: hero&apos;s hp +7");
                herodesc.setText("Angiis can not swim and can only stay underwater for only five minutes.");
                break;
            case 15:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite015);
                hero.setScaleX(1);
                heroname.setText("015 - GUITAI");
                herostat.setText("hp: 56   atk: 11   def: 9   spd: 11\nability: hero&apos;s hp +10");
                herodesc.setText("It is said that there is always a drizzle every time a guitai is present.");
                break;
            case 16:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite016);
                hero.setScaleX(-1);
                heroname.setText("016 - FOOTLE");
                herostat.setText("hp: 19   atk: 5   def: 3   spd: 6\nability: enemy&apos;s attack -1");
                herodesc.setText("Because of their large feet, they walk almost like penguins.");
                break;
            case 17:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite017);
                hero.setScaleX(1);
                heroname.setText("017 - TROUSLE");
                herostat.setText("hp: 29   atk: 8   def: 5   spd: 9\nability: enemy&apos;s attack -2");
                herodesc.setText("They use only their wings as legs that's why their feet are so small.");
                break;
            case 18:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite018);
                hero.setScaleX(-1);
                heroname.setText("018 - MANANGLE");
                herostat.setText("hp: 51   atk: 14   def: 9   spd: 16\nability: enemy&apos;s attack -5");
                herodesc.setText("Their wings can double as large arms, they have great mobility on land that they don't fly during hunts.");
                break;
            case 19:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite019);
                hero.setScaleX(1);
                heroname.setText("019 - SHIDDEN");
                herostat.setText("hp: 18   atk: 7   def: 2   spd: 5\nability: enemy&apos;s hp -5");
                herodesc.setText("Shiddens can hide in shadows. They are playful creatures.");
                break;
            case 20:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite020);
                hero.setScaleX(-1);
                heroname.setText("020 - NYADOW");
                herostat.setText("hp: 27   atk: 11   def: 3   spd: 8\nability: enemy&apos;s hp -7");
                herodesc.setText("Nyadows are good in misdirections. They can attact or flee without their enemies noticing them.");
                break;
            case 21:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite021);
                hero.setScaleX(1);
                heroname.setText("021 - KLATZINOIR");
                herostat.setText("hp: 47   atk: 19   def: 5   spd: 14\nability: enemy&apos;s hp -10");
                herodesc.setText("They don't waste a lot of energy when hunting, they can just attract their preys.");
                break;
            case 22:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.INVISIBLE);
                ne.setClickable(false);
                hero.setImageResource(R.drawable.sprite000);
                hero.setScaleX(1);
                heroname.setText("000 - DUMMIE");
                herostat.setText("hp: 10   atk: 0   def: 0   spd: 0\nability: hero&apos;s hp +10");
                herodesc.setText("Unattainable, not a hero, just a punching bag, that&apos;s all.");
                break;
        }

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void n (View view) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        count1+=1;
        TextView heroname = (TextView) findViewById(R.id.nameView);
        TextView herostat = (TextView) findViewById(R.id.statView);
        TextView herodesc = (TextView) findViewById(R.id.triviaView);
        ImageView hero = (ImageView) findViewById(R.id.spriteView);
        Button pr = (Button) findViewById(R.id.previous);
        Button ne = (Button) findViewById(R.id.next);

        switch (count1) {
            case 1:
                pr.setVisibility(View.INVISIBLE);
                pr.setClickable(false);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite001);
                hero.setScaleX(1);
                heroname.setText("001 - FLAMELING");
                herostat.setText("hp: 20   atk: 5   def: 3   spd: 5\nability: enemy&apos;s hp -10");
                herodesc.setText("Flamelings live in nearby swamps deep in forests.");
                break;
            case 2:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite002);
                hero.setScaleX(-1);
                heroname.setText("002 - BLAZELET");
                herostat.setText("hp: 30   atk: 8   def: 5   spd: 8\nability: hero&apos;s hp +10");
                herodesc.setText("Blazelet stands still for a long time to conserve energy.");
                break;
            case 3:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite003);
                hero.setScaleX(1);
                heroname.setText("003 - BLAZEKRIEG");
                herostat.setText("hp: 53   atk: 14   def: 9   spd: 14\nability: hero&apos;s attack +5");
                herodesc.setText("Blazekriegs are said to be reborn into flamelings upon death.");
                break;
            case 4:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite004);
                hero.setScaleX(-1);
                heroname.setText("004 - MUSHBRO");
                herostat.setText("hp: 21   atk: 4   def: 4   spd: 3\nability: hero&apos;s defense +1");
                herodesc.setText("Wether a mushbro is happy or not their facial expression does not change.");
                break;
            case 5:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite005);
                hero.setScaleX(1);
                heroname.setText("005 - MUSHBRAD");
                herostat.setText("hp: 32   atk: 6   def: 6   spd: 5\nability: hero&apos;s defense +2");
                herodesc.setText("They would stumble often and they struggle in getting up.");
                break;
            case 6:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite006);
                hero.setScaleX(-1);
                heroname.setText("006 - MUSHBOSS");
                herostat.setText("hp: 56   atk: 11   def: 11   spd: 9\nability: hero&apos;s defense +5");
                herodesc.setText("Despite of their intimidating size they prefer using their minds than brute force.");
                break;
            case 7:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite007);
                hero.setScaleX(1);
                heroname.setText("007 - SPARKIE");
                herostat.setText("hp: 19   atk: 6   def: 3   spd: 7\nability: hero&apos;s attack +1");
                herodesc.setText("Sparkies can climb walls. The metallic ball like part at the tip of their tail stores electricity.");
                break;
            case 8:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite008);
                hero.setScaleX(-1);
                heroname.setText("008 - SPARCHOP");
                herostat.setText("hp: 29   atk: 9   def: 5   spd: 11\nability: hero&apos;s attack +2");
                herodesc.setText("Their snout can discharge electricity. During discharge they sometimes float a little bit.");
                break;
            case 9:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite009);
                hero.setScaleX(1);
                heroname.setText("009 - HAMPERE");
                herostat.setText("hp: 52   atk: 16   def: 9   spd: 19\nability: hero&apos;s attack +5");
                herodesc.setText("Unlike sparkies and sparkchops, hamperes can't climb walls due to their weight.");
                break;
            case 10:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite010);
                hero.setScaleX(-1);
                heroname.setText("010 - LEAFLE");
                herostat.setText("hp: 22   atk: 5   def: 3   spd: 4\nability: enemy&apos;s defense -1");
                herodesc.setText("The leaf at the tip of their tail can cut through branches.");
                break;
            case 11:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite011);
                hero.setScaleX(1);
                heroname.setText("011 - SEEDSHELL");
                herostat.setText("hp: 33   atk: 8   def: 5   spd: 6\nability: enemy&apos;s defense -2");
                herodesc.setText("The shell covering their fists can act as a weapon and a shield.");
                break;
            case 12:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite012);
                hero.setScaleX(-1);
                heroname.setText("012 - SEEDWING");
                herostat.setText("hp: 58   atk: 14   def: 9   spd: 11\nability: enemy&apos;s defense -5");
                herodesc.setText("They store energy from sunlight, enough energy for them to keep flying more than a day.");
                break;
            case 13:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite013);
                hero.setScaleX(1);
                heroname.setText("013 - DRIPLET");
                herostat.setText("hp: 21   atk: 4   def: 3   spd: 4\nability: hero&apos;s hp +5");
                herodesc.setText("They are warm but always wet. It is impossible to make driplets dry.");
                break;
            case 14:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite014);
                hero.setScaleX(-1);
                heroname.setText("014 - ANGII");
                herostat.setText("hp: 32   atk: 6   def: 5   spd: 6\nability: hero&apos;s hp +7");
                herodesc.setText("Angiis can not swim and can only stay underwater for only five minutes.");
                break;
            case 15:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite015);
                hero.setScaleX(1);
                heroname.setText("015 - GUITAI");
                herostat.setText("hp: 56   atk: 11   def: 9   spd: 11\nability: hero&apos;s hp +10");
                herodesc.setText("It is said that there is always a drizzle every time a guitai is present.");
                break;
            case 16:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite016);
                hero.setScaleX(-1);
                heroname.setText("016 - FOOTLE");
                herostat.setText("hp: 19   atk: 5   def: 3   spd: 6\nability: enemy&apos;s attack -1");
                herodesc.setText("Because of their large feet, they walk almost like penguins.");
                break;
            case 17:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite017);
                hero.setScaleX(1);
                heroname.setText("017 - TROUSLE");
                herostat.setText("hp: 29   atk: 8   def: 5   spd: 9\nability: enemy&apos;s attack -2");
                herodesc.setText("They use only their wings as legs that's why their feet are so small.");
                break;
            case 18:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite018);
                hero.setScaleX(-1);
                heroname.setText("018 - MANANGLE");
                herostat.setText("hp: 51   atk: 14   def: 9   spd: 16\nability: enemy&apos;s attack -5");
                herodesc.setText("Their wings can double as large arms, they have great mobility on land that they don't fly during hunts.");
                break;
            case 19:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite019);
                hero.setScaleX(1);
                heroname.setText("019 - SHIDDEN");
                herostat.setText("hp: 18   atk: 7   def: 2   spd: 5\nability: enemy&apos;s hp -5");
                herodesc.setText("Shiddens can hide in shadows. They are playful creatures.");
                break;
            case 20:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite020);
                hero.setScaleX(-1);
                heroname.setText("020 - NYADOW");
                herostat.setText("hp: 27   atk: 11   def: 3   spd: 8\nability: enemy&apos;s hp -7");
                herodesc.setText("Nyadows are good in misdirections. They can attact or flee without their enemies noticing them.");
                break;
            case 21:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.VISIBLE);
                ne.setClickable(true);
                hero.setImageResource(R.drawable.sprite021);
                hero.setScaleX(1);
                heroname.setText("021 - KLATZINOIR");
                herostat.setText("hp: 47   atk: 19   def: 5   spd: 14\nability: enemy&apos;s hp -10");
                herodesc.setText("They don't waste a lot of energy when hunting, they can just attract their preys.");
                break;
            case 22:
                pr.setVisibility(View.VISIBLE);
                pr.setClickable(true);
                ne.setVisibility(View.INVISIBLE);
                ne.setClickable(false);
                hero.setImageResource(R.drawable.sprite000);
                hero.setScaleX(1);
                heroname.setText("000 - DUMMIE");
                herostat.setText("hp: 10   atk: 0   def: 0   spd: 0\nability: hero&apos;s hp +10");
                herodesc.setText("Unattainable, not a hero, just a punching bag, that&apos;s all.");
                break;
        }
    }

    public void b (View view) {
        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.stop();
        }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        Intent test = new Intent(this, ExtrasMenu.class);
        startActivity(test);
    }

    public void onBackPressed(){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        Intent test = new Intent(this, QuitGame.class);
        startActivity(test);

    }

}
