package com.thedebelopers.discheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class TutorialPop extends AppCompatActivity {

    int popper=CollectPhase.hey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));

        setContentView(R.layout.pop_tutorial);

        View im = (View) findViewById(R.id.backg);

        if (popper==1){
            im.setBackgroundResource(R.drawable.missed);

        } else if (popper==2){
            im.setBackgroundResource(R.drawable.hit);

        } else if (popper==3){
            im.setBackgroundResource(R.drawable.slam);

        } else {
            im.setBackgroundResource(R.drawable.bg_book);
        }
    }


}
