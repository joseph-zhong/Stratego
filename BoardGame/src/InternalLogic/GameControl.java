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
    private Computer comp1;


    public GameControl()
    {
        board = new Board();
//        comp1 = new Computer();
    }

    public Computer getComputer()
    {
        return comp1;
    }

    public Board getBoard()
    {
        return board;
    }
}
