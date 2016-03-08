/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thedebelopers.discheroes.framework;



/**
 *
 * @author MSi
 */

public interface Game {

    public Audio getAudio();

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getInitScreen();
}
 
