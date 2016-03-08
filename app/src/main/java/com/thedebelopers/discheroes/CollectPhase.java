package com.thedebelopers.discheroes;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.thedebelopers.discheroes.Shufflebag;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CollectPhase extends AppCompatActivity {
    int c = StoryMenu.nosepick;

    private SeekBar seekBar = null;
    boolean NotTouched = true;
    int i1 = 0;
    int th = 0;
    int svc1 = 0;
    int cpc1 = 0;
    int svc2 = 0;
    int cpc2 = 0;
    private View pogstack;
    String []s = new String[20];
    String []sv1 = new String[20];
    String []sv2 = new String[20];
    String []cp1 = new String[20];
    String []cp2 = new String[20];
    String nholder;
    static int staku;
    public static int hey=0;
    Button gitna = (Button) findViewById(R.id.stack);

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("profiles.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private Thread seekBarThread = new Thread() {
        @Override
        public void run() {
            while (NotTouched) {
                try {
                        i1 += 1;
                    if (seekBar.getProgress() == seekBar.getMax()) {
                        seekBar.setProgress(0);
                        i1 = 0;
                    } else seekBar.setProgress(i1);
                        Thread.sleep(2);
                } catch (Exception ex) {
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextView aa, ab, ad, ae, af, ag, ah;
        Intent get = getIntent();
        String[] te1 = get.getStringArrayExtra("team1");
        String[] te2 = get.getStringArrayExtra("team2");

        int y=0;

        for(int z=0;z<te1.length;z++){
            if(te1[z]!=null){
                s[y] = te1[z];
                y+=1;
            }
        }

        for(int z=0;z<te2.length;z++){
            s[y] = te2[z];
            y+=1;
        }

        Random random1; //shufflebag starts
        random1 = new Random();


        for (int i = 0; i < y; i++)
        {
            // NextDouble returns a random number between 0 and 1.
            // ... It is equivalent to Math.random() in Java.
            int r = i + (int)(random1.nextDouble() * (y - i));
            String t = s[r];
            s[r] = s[i];
            s[i] = t;
        }

        //shufflebag ends

        //shuffling = new Shufflebag();
        //shuffling.Shuffle(s);

        staku = y;

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.phase_collect);
        aa = (TextView) findViewById(R.id.team1);
        ab = (TextView) findViewById(R.id.team2);
        final TextView ac = (TextView) findViewById(R.id.counter);
        ad = (TextView) findViewById(R.id.saved1);
        ae = (TextView) findViewById(R.id.saved2);
        af = (TextView) findViewById(R.id.capt1);
        ag = (TextView) findViewById(R.id.capt2);
        ah = (TextView) findViewById(R.id.mesaj);
        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");
        aa.setTypeface(ampersand);
        ab.setTypeface(ampersand);
        ac.setTypeface(ampersand);
        ad.setTypeface(ampersand);
        ae.setTypeface(ampersand);
        af.setTypeface(ampersand);
        ag.setTypeface(ampersand);
        ah.setTypeface(ampersand);
        MediaPlayer bgm = MediaPlayer.create(getApplicationContext(), R.raw.mus_battle2);
        bgm.setVolume(0.75f, 0.75f);
        bgm.setLooping(true);
        bgm.start();

        //ad.setText("0-" + s[0] + ",1-" + s[1] + ",2-" + s[2] + ",3-" + s[3] + ",4-" + s[4] + ",5-" + s[5] + ",6-" + s[6] + ",7-" + s[7] + ",8-" + s[8] + ",9-" + s[9] + ",10-" + s[10] + ",11-" + s[11] + ",12-" + s[12] + ",13-" + s[13] + ",14-" + s[14] + ",15-" + s[15] + ",16-" + s[16] + ",17-" + s[17] + ",18-" +s[18]+",19-"+s[19]);

        if (staku==1||staku==0){
            ac.setText(staku+" POG left");
        }
        if (staku>1){
            ac.setText(staku+" POGs left");
        }



        View taphere = findViewById(R.id.taphere);
        if(c!=1){
            taphere.setVisibility(View.INVISIBLE);
        }else{
            taphere.setVisibility(View.VISIBLE); //just to make sure it would be visible
            /*if (th<1751){
                th = 0;
            } else {
                th += 1;
            }
            ImageView taphere = (ImageView) findViewById(R.id.taphere);
            if(th>=0&&th<=550){
                taphere.setImageResource(R.drawable.tap_anim_1);
            } else if (th>550&&th<=750){
                taphere.setImageResource(R.drawable.tap_anim_2);
            } else{
                taphere.setImageResource(R.drawable.tap_anim_3);
            }*/
        }

        final Intent pop = new Intent(this, TutorialPop.class);

        seekBar = (SeekBar) findViewById(R.id.gauge);
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        try {
            seekBarThread.start();
        } catch (Exception ex) {
            ex.printStackTrace();        }
        final Intent baph = new Intent(this, BattlePhase.class);
        pogstack = findViewById(R.id.stack);
        pogstack.setOnTouchListener(new View.OnTouchListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            public boolean onTouch(View v, MotionEvent evt) {
                if ((evt.getAction() == MotionEvent.ACTION_DOWN)) {
                    try {
                        View taphere = findViewById(R.id.taphere);
                        taphere.setVisibility(View.INVISIBLE);


                        //setProgress 0 to 39 red
                        //setProgress 40 to 83 yellow
                        //setProgress 84 to 100 green


////Missed
                        if(seekBar.getProgress()<40){
                            ah.setText("Missed!\nEnemy's turn");

                            final Handler handler = new Handler();
                            Timer t = new Timer();
                            t.schedule(new TimerTask() {
                                public void run() {
                                    handler.post(new Runnable() {
                                        public void run() {/*


                                            if(seekBar.getProgress()<40){
                                                ah.setText("Missed!\nEnemy's turn");

                                                final Handler handler = new Handler();
                                                Timer t = new Timer();
                                                t.schedule(new TimerTask() {
                                                    public void run() {
                                                        handler.post(new Runnable() {
                                                            public void run() {


                                                            }
                                                        });
                                                    }
                                                }, 2000);

                                            }
                                            if(seekBar.getProgress()>39&&seekBar.getProgress()<84){
                                                String lett = s[th];
                                                char [] err = lett.toCharArray();
                                                char [] err1 = new char[err.length-1];
                                                if(err[0]=='1'){
                                                    for(int i = 1; i < err.length; i++){
                                                        err1[i-1]=err[i];
                                                    }
                                                    sv1[svc1]= err1.toString();

                                                    nholder=sv1[svc1];

                                                    svc1++;
                                                    ad.setText("saved: "+svc1);

                                                    ah.setText("Hit! You saved a "+sv1[svc1]+"\nEnemy's turn");
                                                }

                                                if(err[0]=='2'){
                                                    for(int i = 1; i < err.length; i++){
                                                        err1[i-1]=err[i];
                                                    }
                                                    cp1[cpc1]= err1.toString();

                                                    nholder = cp1[cpc1];

                                                    cpc1++;
                                                    af.setText("captured: "+cpc1);

                                                    ah.setText("Hit! You captured a "+ cp1[cpc1] +"\nEnemy's turn");
                                                }

                                                th++;
                                                staku--;
                                                if (staku==0){
                                                    startActivity(baph);
                                                }
                                                if (staku==1){
                                                    ac.setText(staku + " POG left");
                                                }
                                                if (staku>1){
                                                    ac.setText(staku + " POGs left");
                                                }

                                            }
                                            if(seekBar.getProgress()>83){
                                                String lett = s[th];
                                                char [] err = lett.toCharArray();
                                                char [] err1 = new char[err.length-1];
                                                if(err[0]=='1'){
                                                    for(int i = 1; i < err.length; i++){
                                                        err1[i-1]=err[i];
                                                    }
                                                    sv1[svc1]= err1.toString();

                                                    nholder = sv1[svc1];

                                                    svc1++;
                                                    ad.setText("saved: "+svc1);

                                                    ah.setText("Hit! You saved a "+sv1[svc1]+"\nEnemy's turn");
                                                }

                                                if(err[0]=='2'){
                                                    for(int i = 1; i < err.length; i++){
                                                        err1[i-1]=err[i];
                                                    }
                                                    cp1[cpc1]= err1.toString();

                                                    nholder = cp1[cpc1];

                                                    cpc1++;
                                                    af.setText("captured: "+cpc1);

                                                    ah.setText("Hit! You captured a "+cp1[cpc1]+"\nEnemy's turn");
                                                }

                                                th++;
                                                staku--;
                                                if (staku==0){
                                                    startActivity(baph);
                                                }
                                                if (staku==1){
                                                    ac.setText(staku+" POG left");
                                                }
                                                if (staku>1){
                                                    ac.setText(staku+" POGs left");
                                                }

                                            }


                                            */
                                        }
                                    });
                                }
                            }, 2000);


////Hit
                        }
                        if(seekBar.getProgress()>39&&seekBar.getProgress()<84){
                            String lett = s[th];
                            char [] err = lett.toCharArray();
                            char [] err1 = new char[err.length-1];
                            if(err[0]=='1'){
                                for(int i = 1; i < err.length; i++){
                                    err1[i-1]=err[i];
                                }
                                sv1[svc1]= err1.toString();

                                nholder=sv1[svc1];

                                svc1++;
                                ad.setText("saved: "+svc1);

                                ah.setText("Hit! You saved a "+sv1[svc1]+"\nEnemy's turn");
                            }

                            if(err[0]=='2'){
                                for(int i = 1; i < err.length; i++){
                                    err1[i-1]=err[i];
                                }
                                cp1[cpc1]= err1.toString();

                                nholder = cp1[cpc1];

                                cpc1++;
                                af.setText("captured: "+cpc1);

                                ah.setText("Hit! You captured a "+ cp1[cpc1] +"\nEnemy's turn");
                            }

                            th++;
                            staku--;
                            if (staku==0){
                                startActivity(baph);
                            }
                            if (staku==1){
                                ac.setText(staku + " POG left");
                            }
                            if (staku>1){
                                ac.setText(staku + " POGs left");
                            }

                        }


////slam
                        if(seekBar.getProgress()>83){
                            String lett = s[th];
                            char [] err = lett.toCharArray();
                            char [] err1 = new char[err.length-1];
                            if(err[0]=='1'){
                                for(int i = 1; i < err.length; i++){
                                    err1[i-1]=err[i];
                                }
                                sv1[svc1]= err1.toString();

                                nholder = sv1[svc1];

                                svc1++;
                                ad.setText("saved: "+svc1);

                                ah.setText("Hit! You saved a "+sv1[svc1]+"\nEnemy's turn");
                            }

                            if(err[0]=='2'){
                                for(int i = 1; i < err.length; i++){
                                    err1[i-1]=err[i];
                                }
                                cp1[cpc1]= err1.toString();

                                nholder = cp1[cpc1];

                                cpc1++;
                                af.setText("captured: "+cpc1);

                                ah.setText("Hit! You captured a "+cp1[cpc1]+"\nEnemy's turn");
                            }

                            th++;
                            staku--;
                            if (staku==0){
                                startActivity(baph);
                            }
                            if (staku==1){
                                ac.setText(staku+" POG left");
                            }
                            if (staku>1){
                                ac.setText(staku+" POGs left");
                            }

                        }



////end chuchu
                        seekBarThread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
    }

//    public void pogstack (View view) {
//    }
public void onBackPressed(){
    if (MainActivity.bgm.isPlaying()) {
        MainActivity.bgm.stop();
    }
    MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
    mp.start();

    Intent test = new Intent(this, StoryMenu.class);
    startActivity(test);

}

}