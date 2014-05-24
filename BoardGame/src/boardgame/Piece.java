/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stratego;

/**
 *
 * @author Adarsh
 */
import java.awt.*;
abstract class Piece 
{
    private int power;
    private int ability;
    private int distanceCapable;
    private Image face;
    private Cell location;
    
    public Piece(int p, int a, int d, Image f)
    {
        power = p;
        ability = a;
        distanceCapable = d;
        face = f;
    }
    
    public int move(int disToMove)
    {
        if (disToMove <= distanceCapable)
        {
            //cell logic
        }
        return -1; //cannot move distanceCapable
    }
    
    public int getPower()
    { return power; }
    public int getAbility()
    { return ability; }
    public int getDistanceCapable()
    { return distanceCapable; }
    public Image getFace()
    { return face; }
    
}
