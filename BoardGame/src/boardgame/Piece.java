/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

/**
 *
 * @author Adarsh
 */
import java.awt.*;
abstract class Piece
{
    private int power;
    private char ability;
    private int distanceCapable;
    private Image face;
    private Cell location;

    public Piece(int p, char a, int d, Image f)
    {
        power = p;
        ability = a;
        distanceCapable = d;
        face = f;
    }
    
    public void setCell(Cell cell)
    { location = cell; }
    
    public int getPower()
    { return power; }

    public char getAbility()
    { return ability; }

    public Cell getCell()
    { return location; }

    public int getDistanceCapable()
    { return distanceCapable; }

    public Image getFace()
    { return face; }

}
