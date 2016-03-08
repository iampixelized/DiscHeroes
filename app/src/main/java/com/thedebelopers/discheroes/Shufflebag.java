package com.thedebelopers.discheroes;

import java.util.Random;

/**
 * Created by Eli on 3/7/2016.
 */
public class Shufflebag {
    static Random random1 = new Random();
    static void Shuffle(int [] array){

        array = new int[20];
        int n = array.length;
        for (int i = 0; i < n; i++)
        {
            // NextDouble returns a random number between 0 and 1.
            // ... It is equivalent to Math.random() in Java.
            int r = i + (int)(random1.nextDouble() * (n - i));
            int t = array[r];
            array[r] = array[i];
            array[i] = t;
        }


    //array[] = new String[] s;
    Shuffle(array);

    //int yo = CollectPhase.staku;
    //int i =0;

    //while(i<yo){
     //   System.out.println(array[i]);
     //   i+=1;
    //}

    }

}
