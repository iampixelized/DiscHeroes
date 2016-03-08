/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thedebelopers.discheroes.framework;

/**
 *
 * @author MSi
 */

public interface Music {
    public void play();

    public void stop();

    public void pause();

    public void setLooping(boolean looping);

    public void setVolume(float volume);

    public boolean isPlaying();

    public boolean isStopped();

    public boolean isLooping();

    public void dispose();

    void seekBegin();
}
