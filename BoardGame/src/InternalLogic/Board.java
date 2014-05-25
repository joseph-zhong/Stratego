/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalLogic;

import Pieces.*;

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
        Piece p = new Scout();
        b.put(new Sergeant(), new Cell(3,4));
        b.put(p, new Cell(7,4));
        if(b.canMove(p, new Cell(3,4)))
        {
            b.move(p, new Cell(3,4));
        }
        System.out.println(b.toString());
    }
    public Piece put(Piece p, Cell target)
    {
        Piece temp = grid[target.getRow()][target.getCol()];
        grid[target.getRow()][target.getCol()] = p;
        return temp;
    }

    public boolean canMove(Piece p, Cell target)
    {
        Cell currentCell = findPieceInGrid(p);
        if(currentCell == null)
        {
            return false;
        }
        //if target cell is current location, false
        if(currentCell.equals(target))
        {
            return false;
        }
        //if the two points are in same row
        if(currentCell.getRow() == target.getRow())
        {
            //if points are within range
            if(Math.abs(currentCell.getCol() - target.getCol()) <= p.getDistanceCapable())
            {
                //if current cell is left of target
                if(currentCell.getCol() < target.getCol())
                {
                    for(int i = currentCell.getCol(); i < target.getCol(); i++)
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
                    for(int i = target.getCol(); i > currentCell.getCol(); i--)
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
        else if(currentCell.getCol() == target.getCol())
        {
            //if points are within range
            if(Math.abs(currentCell.getRow() - target.getRow()) <= p.getDistanceCapable())
            {
                //if current cell is above of target
                if(currentCell.getRow() < target.getRow())
                {
                    for(int i = currentCell.getRow(); i < target.getRow(); i++)
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
                    for(int i = target.getRow(); i > currentCell.getRow(); i--)
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


    //move() returns whether there was an attack and values should be revealed
    public boolean move(Piece p, Cell target)
    {
        Piece pieceInTargetCell = grid[target.getRow()][target.getCol()];
        Cell currentCell =  findPieceInGrid(p);
        //if target is empty, move to target location
        if( pieceInTargetCell == null)
        {
            put(p, target);
            return false;
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
                grid[currentCell.getRow()][currentCell.getCol()] = null;
            }
            return true;
        }
    }

    public String toString()
    {
        String str = "";
        for(Piece[] p: grid)
        {
            for(Piece q: p)
            {
                if(q == null)
                {
                    str += "X ";
                }
                else
                {
                    str += (q.toString() + " ");
                }
            }
            str += "\n";
        }
        return str;
    }

    private Cell findPieceInGrid(Piece p)
    {
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[row].length; col++)
            {
                if(grid[row][col] == p)
                {
                    return new Cell(row,col);
                }
            }
        }
        return null;
    }
}
