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

    private Piece[][] grid = new Piece[10][10];

    public Board()
    {
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; i++)
            {
                grid[i][j] = new Cell(i,j);
            }
        }   
    }
    
    public boolean canMove(Piece p, Cell target)
    {
        if((p.getCell().getX() == target.getX() || p.getCell().getY() == target.getY() ) && (Math.abs(p.getCell().getX() - target.getX()) <= p.getDistanceCapable()) || (Math.abs(p.getCell().getY() - target.getY()) <= p.getDistanceCapable()))
        {
            return true;
        }
        return false;
    }
    
    public void move(Piece p, Cell target)
    {
        if(grid[target.getX()][target.getY()] == null)
        {
            p.setCell(target);
        }
        else
        {
            p.attack();
        }
    }

}
