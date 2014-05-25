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
        Piece temp = grid[target.getX()][target.getY()];
        grid[target.getX()][target.getY()] = p;
        return temp;
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
        Piece pieceInTargetCell = grid[target.getX()][target.getY()];
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
                grid[p.getCell().getX()][p.getCell().getY()] = null;
            }
        }
    }

}
