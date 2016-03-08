/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thedebelopers.discheroes.framework;

/**
 *
 * @author MSi
 */

import com.thedebelopers.discheroes.framework.Graphics.ImageFormat;

public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}
