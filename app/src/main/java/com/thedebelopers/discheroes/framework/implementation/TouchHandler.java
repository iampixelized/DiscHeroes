/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thedebelopers.discheroes.framework.implementation;

/**
 *
 * @author MSi
 */

import java.util.List;

import android.view.View.OnTouchListener;

import com.thedebelopers.discheroes.framework.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);
   
    public int getTouchX(int pointer);
   
    public int getTouchY(int pointer);
   
    public List<TouchEvent> getTouchEvents();
}