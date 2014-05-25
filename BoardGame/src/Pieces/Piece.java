/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

/**
 *
 * @author Adarsh
 */
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Piece
{
    private int power;
    private char ability;
    private int distanceCapable;
    private BufferedImage face;

    public Piece(int p, char a, int d, BufferedImage f)
    {
        power = p;
        ability = a;
        distanceCapable = d;
        face = f;
    }

    public boolean attack(Piece p)
    {
        //if attacks flag
        if(p.getPower() == 0)
        {
            return true;
        }
        //3 attacks bomb
        if(power == 3 && p.getPower() == 11)
        {
            return true;
        }
        //otherwise if attacks bomb, die
        if(p.getPower() == 11)
        {
            return true;
        }
        //if spy attacks 10
        if(power == 1 && p.getPower() == 10)
        {
            return true;
        }
        //otherwise compare power values
        return power >= p.getPower();
    }

    public int getPower()
    { return power; }

    public char getAbility()
    { return ability; }



    public int getDistanceCapable()
    { return distanceCapable; }

    public Image getFace()
    { return face; }

    public String toString()
    {
        return Integer.toString(power);
    }
}
