package com.thedebelopers.discheroes;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by Eli on 2/14/2016.
 */
public class DeleteProfile extends Activity {

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

    String s = MainActivity.getbutt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_delete);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .5), (int) (height * .3 ));

        TextView tb, cb;
        tb = (TextView) findViewById(R.id.textView);
        cb = (TextView) findViewById(R.id.confirm);
        Typeface ampersand = Typeface.createFromAsset(getAssets(), "fonts/ampersand.ttf");
        tb.setTypeface(ampersand);
        cb.setTypeface(ampersand);


        String n1 = MainActivity.getnam1();
        String n2 = MainActivity.getnam2();

        if(s=="prof1"){
            tb.setText("Are you sure you want "+n1+" to be deleted?");
        }
        if (s=="prof2"){
            tb.setText("Are you sure you want "+n2+" to be deleted?");
        }

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

    public void yah (View view) {
        if (MainActivity.bgm.isPlaying()) {
            MainActivity.bgm.pause();
            MainActivity.pos = MainActivity.bgm.getCurrentPosition();
            MainActivity.bgm.stop();
        }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.book_flip);
        mp.start();

            try {
                //JSONParser parser = new JSONParser();
                //FileReader file = new FileReader("assets/profiles.json");
                //Object new_object = parser.parse(file);
                //JSONObject obj = (JSONObject) new_object;
                JSONObject obj = new JSONObject(loadJSONFromAsset());
                JSONArray m_jArry = obj.getJSONArray("profile");

                for (int i = 0; i < m_jArry.length(); i++) {
                    JSONObject jo_inside = m_jArry.getJSONObject(i);
                    int id_value = Integer.parseInt(jo_inside.getString("id"));
                    //String name_value = jo_inside.getString("name");
                    int save_value = Integer.parseInt(jo_inside.getString("save"));
                    //int gold_value = Integer.parseInt(jo_inside.getString("gold"));
                    //int chapter_value = Integer.parseInt(jo_inside.getString("chapter"));

                    if (id_value == 1){
                        if(save_value==1) {

                            FileWriter file1 = new FileWriter(loadJSONFromAsset());
                            file1.flush();

                            jo_inside.put("id",new Integer(1));
                            jo_inside.put("name", "");
                            jo_inside.put("save", new Integer(0));
                            jo_inside.put("gold", new Integer(0));
                            jo_inside.put("chapter", new Integer(0));

                            file1.write(jo_inside.toString());
                            file1.close();
                        }
                    }

                    if (id_value == 2){
                        if(save_value==1){

                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


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