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
import InternalLogic.*;

public abstract class Piece
{
    private int power;
    private char ability;
    private int distanceCapable;
    private BufferedImage face;
    
    private Cell cell;
    private Board board;

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
    
    public Cell getCell()
    { return cell; }

    public void setCell(Cell c)
    { cell = c; }
    
    public void setCell(int x, int y)
    { cell = new Cell(x, y); }
    
    public void putOnBoard(Board b, Cell c)
    {
        board.put(this, c);
    }
    
    public void removeFromBoard()
    {
        board.put(null, cell);
    }
    
    public void moveTo(Cell c)
    {
        board.movePieceTo(this, c);
    }
    
    public String toString()
    {
        return Integer.toString(power);
    }
}
