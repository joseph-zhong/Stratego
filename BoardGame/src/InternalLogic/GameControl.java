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
    private Board board;
    
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
