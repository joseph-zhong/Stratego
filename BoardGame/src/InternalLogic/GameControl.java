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
public class GameControl
{
    private Board board;

    public GameControl()
    {
        board = new Board();
    }

    public Board getBoard()
    {
        return board;
    }
}
