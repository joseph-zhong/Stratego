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
    private Computer comp;


    public GameControl()
    {
        board = new Board();
        comp = new Computer();
    }

    public Computer getComputer()
    {
        return comp;
    }

    public Board getBoard()
    {
        return board;
    }
}
