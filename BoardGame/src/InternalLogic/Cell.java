/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalLogic;

import Pieces.*;
public class Cell {
    private Piece piece;
    private boolean hasWater;
    
    public Cell()
    {
        piece = null;
        hasWater = false;
    }
    public boolean hasWater()
    {
        return hasWater;
    }
    public void setHasWater(boolean b)
    {
        hasWater = b;
    }
    public void removePiece()
    {
        piece = null;
    }
    public void put(Piece p)
    {
        piece = p;
    }
    public Piece get()
    {
        return piece;
    }
}
