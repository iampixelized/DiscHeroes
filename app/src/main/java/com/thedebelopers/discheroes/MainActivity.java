package com.thedebelopers.discheroes;
import com.thedebelopers.discheroes.framework.implementation.AndroidMusic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    //JSONParser parser = new JSONParser();

    public static MediaPlayer bgm;

    public static int pos=0;

    private static String butt;

    public static String getbutt() {
        return butt;
    }

    //public void setbutt(String butt) {
    //    this.butt = butt;
    //}

    private static String nam1;
    public static String getnam1() {
        return nam1;
    }

    private static String nam2;
    public static String getnam2() {
        return nam2;
    }

    TextView aa,ab;

    /*
    private boolean mIsBound = false;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(getIntent().getBooleanExtra("EXIT",false)){
            finish();
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //Intent music = new Intent();
        //music.setClass(this, MusicService.class);
        //startService(music);

        aa= (TextView) findViewById(R.id.profilebutton1);
        ab= (TextView) findViewById(R.id.profilebutton2);
        View da= findViewById(R.id.deletebutton1);
        View db= findViewById(R.id.deletebutton2);
        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");
        aa.setTypeface(ampersand);
        ab.setTypeface(ampersand);

        try {
            //FileReader file = new FileReader("assets/profiles.json");
            //Object new_object = parser.parse(file);
            //JSONObject obj = (JSONObject) new_object;
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("profile");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                int id_value = Integer.parseInt(jo_inside.getString("id"));
                String name_value = jo_inside.get("name").toString();
                int save_value = Integer.parseInt(jo_inside.getString("save"));


                if (id_value == 1){
                    if(save_value==0) {
                        aa.setText("New Game");
                    }
                    if(save_value==1) {
                        aa.setText(name_value);
                        nam1 = name_value;
                    }
                }

                if (id_value == 2){
                    if(save_value==0) {
                        ab.setText("New Game");
                    }
                    if(save_value==1){
                       ab.setText(name_value);
                        nam2 = name_value;
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        if (aa.getText()=="New Game"||nam1==null){
            da.setVisibility(View.INVISIBLE);
            da.setClickable(false);
        } else {
            da.setVisibility(View.VISIBLE);
            da.setClickable(true);
        }

        if (ab.getText()=="New Game"||nam2==null){
            db.setVisibility(View.INVISIBLE);
            db.setClickable(false);
        } else {
            db.setVisibility(View.VISIBLE);
            db.setClickable(true);
        }

        bgm = MediaPlayer.create(getApplicationContext(), R.raw.mus_menu3);
        bgm.setLooping(true);
        bgm.seekTo(pos);
        bgm.start();

        if (bgm.isPlaying()) {
            bgm.pause();
            pos = bgm.getCurrentPosition();
            bgm.stop();
        }
        if (bgm.isPlaying()==false){
            bgm = MediaPlayer.create(getApplicationContext(), R.raw.mus_menu3);
            bgm.setLooping(true);
            bgm.seekTo(pos);
            bgm.start();
        }


    }

    public void cre1 (View view) {
        if (bgm.isPlaying()) {
            bgm.pause();
            pos = bgm.getCurrentPosition();
            bgm.stop();
        }
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        if (aa.getText()=="New Game"||nam1==null){
            Intent test = new Intent(this, CreateProfile.class);
            startActivity(test);
        } else {
            Intent test = new Intent(this, MainMenu.class);
            startActivity(test);
        }

    }

    public void cre2 (View view) {
        if (bgm.isPlaying()) {
            bgm.pause();
            pos = bgm.getCurrentPosition();
            bgm.stop();
        }
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        if (ab.getText()=="New Game"||nam2==null){
            Intent test = new Intent(this, CreateProfile.class);
            startActivity(test);
        } else {
            Intent test = new Intent(this, MainMenu.class);
            startActivity(test);
        }
    }

    public void del1 (View view) {
        if (bgm.isPlaying()) {
            bgm.pause();
            pos = bgm.getCurrentPosition();
            bgm.stop();
        }
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        butt = "prof1";

        Intent test = new Intent(this, DeleteProfile.class);
        startActivity(test);
    }

    public void del2 (View view) {
        if (bgm.isPlaying()) {
            bgm.pause();
            pos = bgm.getCurrentPosition();
            bgm.stop();
        }
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        butt = "prof2";

        Intent test = new Intent(this, DeleteProfile.class);
        startActivity(test);
    }

    public void onBackPressed(){
        if (bgm.isPlaying()) {
            bgm.pause();
            pos = bgm.getCurrentPosition();
            bgm.stop();
        }
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.book_flip);
        mp.start();

        Intent test = new Intent(this, QuitGame.class);
        startActivity(test);

    }

}