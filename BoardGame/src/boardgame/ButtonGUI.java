/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boardgame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 *  Joseph Zhong
 *  ASSIGNMENT_NUMBER
 *  PROGRAM_DESCRIPTION
 *  PROGRAM_TITLE
 *  DATE
 *
 **/

public class ButtonGUI extends Button
{
    // graphics rectangle stuff
    private int x;          // top-left x/y
    private int y;
    private int width;
    private int height;
    private Color color;    // fill color

    private String name;

    public ButtonGUI(int _x, int _y, int _width, int _height, Color _c, String _name)
    {
        x = _x;
        y = _y;
        width = _width;
        height = _height;
        color = _c;
        name = _name;
    }

    /** Draws this button using the given graphics pen. */
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawString(name, x + (int) (width/3.5), y + height/2);
        g.setFont(new Font("sansserif", Font.BOLD, 24));
        g.drawRect(x, y, width, height);
    }

    /** Returns this button's leftmost x coordinate. */
    public int getX()
    {
        return x;
    }

    /** Returns this button's topmost y coordinate. */
    public int getY()
    {
        return y;
    }

    /** Returns this button's width. */
    public int getWidth()
    {
        return width;
    }

    /** Returns this button's height. */
    public int getHeight()
    {
        return height;
    }

    /** Returns this button's color. */
    public Color getColor()
    {
        return color;
    }

    /** Sets this button's leftmost x-coordinate to be the given value. */
    public void setX(int x)
    {
        this.x = x;
    }

    /** Sets this button's topmost y-coordinate to be the given value. */
    public void setY(int y)
    {
        this.y = y;
    }

    /** Returns a text representation of this tile, such as "(x=57,y=148,w=26,h=53)". */
    public String toString()
    {
        return "(x=" + x + ",y=" + y + "),w=" + width + ",h=" + height + ")";
    }
}
