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
            for(int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = null;
            }
        }   
    }
    public static void main(String [] args){
        Board b = new Board();
        b.put(new Bomb(), new Cell(3,4));
    }
    public Piece put(Piece p, Cell target)
    {
        Piece temp = grid[target.getRow()][target.getCol()];
        grid[target.getRow()][target.getCol()] = p;
        return temp;
    }
    
    public boolean canMove(Piece p, Cell target)
    {
        //if target cell is current location, false
        if(p.getCell().equals(target))
        {
            return false;
        }
        //if the two points are in same row
        if(p.getCell().getRow() == target.getRow())
        {
            //if points are within range
            if(Math.abs(p.getCell().getCol() - target.getCol()) <= p.getDistanceCapable())
            {
                //if current cell is left of target
                if(p.getCell().getCol() < target.getCol())
                {
                    for(int i = p.getCell().getCol(); i < target.getCol(); i++)
                    {
                        if(grid[target.getRow()][i] != null 
                                && grid[target.getRow()][i] != p)
                        {
                            return false;
                        }
                    }
                    return true;
                }
                //if current cell is right of target
                else
                {
                    //check if there are any pieces in between piece and target
                    for(int i = target.getCol(); i > p.getCell().getCol(); i--)
                    {
                        if(grid[target.getRow()][i] != null 
                                && grid[target.getRow()][i] != p)
                        {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        //if in same column
        else if(p.getCell().getCol() == target.getCol())
        {
            //if points are within range
            if(Math.abs(p.getCell().getRow() - target.getRow()) <= p.getDistanceCapable())
            {
                //if current cell is above of target
                if(p.getCell().getRow() < target.getRow())
                {
                    for(int i = p.getCell().getRow(); i < target.getRow(); i++)
                    {
                        if(grid[target.getCol()][i] != null 
                                && grid[target.getCol()][i] != p)
                        {
                            return false;
                        }
                    }
                    return true;
                }
                //if current cell is right of target
                else
                {
                    //check if there are any pieces in between piece and target
                    for(int i = target.getRow(); i > p.getCell().getRow(); i--)
                    {
                        if(grid[target.getCol()][i] != null 
                                && grid[target.getCol()][i] != p)
                        {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    public void move(Piece p, Cell target)
    {
        Piece pieceInTargetCell = grid[target.getRow()][target.getCol()];
        //if target is empty, move to target location
        if( pieceInTargetCell == null)
        {
            put(p, target);
        }
        //otherwise attack piece
        else
        {
            //if attack is victorious, replace cell with piece
            if(p.attack(pieceInTargetCell))
            {
                put(p, target);
            }
            //else, remove piece from grid
            else
            {
                grid[p.getCell().getRow()][p.getCell().getCol()] = null;
            }
        }
    }

}
