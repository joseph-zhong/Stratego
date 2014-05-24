/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

/**
 *
 * @author admin
 */
public class Board
{

    private Cell[][] cells = new Cell[10][10];

    public boolean canMove(Piece p, Cell target)
    {
        if((p.getCell().getX() == target.getX() || p.getCell().getY() == target.getY() ) && (Math.abs(p.getCell().getX() - target.getX()) <= p.getDistanceCapable()) || (Math.abs(p.getCell().getY() - target.getY()) <= p.getDistanceCapable()))
        {
            return true;
        }
        return false;
    }



    public Board()
    {
        for(int i = 0; i < cells.length; i++)
        {
            for(int j = 0; j < cells[i].length; i++)
            {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

}
