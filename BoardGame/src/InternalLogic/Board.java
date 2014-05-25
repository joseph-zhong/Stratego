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
    private Cell[][] grid = new Cell[10][10];
    public Board()
    {
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[row].length; col++)
            {
                grid[row][col] = new Cell();
            }
        }
    }
    public static void main(String[] args)
    {
        Board b = new Board();
        b.getCell(3, 4).put(new Major());
        System.out.println(b.toString());

        b.getCell(3, 5).put(new Major());
        System.out.println(b.toString());
        
        if(b.canMove(3,4,3,5))
        {
            b.move(3,4,3,5);
        }
        System.out.println(b.toString());

    }
    public Cell getCell(int row, int col)
    {
        return grid[row][col];
    }
    public boolean canMove(int currentRow, int currentCol, int targetRow, int targetCol)
    {
        if( getCell(currentRow, currentCol).get() == null)
        {
            return false;
        }
        //if target cell is current location, false
        if(currentRow == targetRow && currentCol == targetCol)
        {
            return false;
        }
        //if the two points are in same row
        if(currentRow == targetRow)
        {
            //if points are within range
            if(Math.abs(currentCol - targetCol) <= getCell(currentRow, currentCol).get().getDistanceCapable())
            {
                //if current cell is left of target
                if(currentCol < targetCol)
                {
                    //if cells are adjacemt
                    if(Math.abs(currentCol - targetCol) == 1)
                    {
                        return true;
                    }
                    for(int i = currentCol + 1; i < targetCol; i++)
                    {
                        if(getCell(targetRow, i).get() != null
                                || getCell(targetRow, i).isWater())
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
                    for(int i = targetCol - 1; i > currentCol; i--)
                    {
                        if(getCell(targetRow, i).get() != null
                                || getCell(targetRow, i).isWater())
                        {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        //if in same column
        else if(currentCol== targetCol)
        {
            //if points are within range
            if(Math.abs(currentRow - targetRow) <= getCell(currentRow, currentCol).get().getDistanceCapable())
            {
                //if current cell is above of target
                if(currentRow < targetRow)
                {
                    for(int i = currentRow + 1; i < targetRow; i++)
                    {
                        if(getCell(i, targetCol).get() != null
                                || getCell(i, targetRow).isWater())
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
                    for(int i = targetRow; i > currentRow; i--)
                    {
                        if(getCell(i, targetCol).get() != null
                                || getCell(i, targetRow).isWater())
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
    public boolean move(int currentRow, int currentCol, int targetRow, int targetCol)
    {
        Piece pieceInTargetCell = getCell(targetRow, targetCol).get();
        Piece pieceInCurrentCell = getCell(currentRow, currentCol).get();
        //if target is empty, move to target location
        if( pieceInTargetCell == null)
        {
            getCell(targetRow, targetCol).put(pieceInCurrentCell);
            getCell(currentRow, currentCol).removePiece();
            return false;
        }
        //otherwise attack piece
        else
        {
            //if attack is victorious, replace cell with piece
            if(pieceInCurrentCell.attack(pieceInTargetCell))
            {
                getCell(targetRow, targetCol).put(pieceInCurrentCell);
            }
            //else, remove piece from grid
            else
            {
                getCell(currentRow, currentCol).removePiece();
            }
            return true;
        }
    }
    public String toString()
    {
        String str = "";
        for (int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(getCell(i,j).get() == null)
                {
                    str += "X ";
                }
                else
                {
                    str += (getCell(i,j).get().toString() + " ");

                }
            }
            str += "\n";
        }
        return str;
    }
}
