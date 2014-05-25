/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalLogic;

import Pieces.Piece;

/**
 *
 * @author admin
 */
public class GameControl {
    public boolean canMove(Piece p, Cell target)
    {
        if(p.getCell() == null)
        {
            return false;
        }
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
                        if(p.getBoard().get(target.getRow(), i) != null
                                && p.getBoard().get(target.getRow(),i) != p)
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
                        if(p.getBoard().get(target.getRow(), i) != null
                                && p.getBoard().get(target.getRow(),i) != p)
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
                        if(p.getBoard().get(i, target.getCol()) != null
                                && p.getBoard().get(i, target.getCol()) != p)
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
                        if(p.getBoard().get(i, target.getCol()) != null
                                && p.getBoard().get(i, target.getCol()) != p)
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
}
