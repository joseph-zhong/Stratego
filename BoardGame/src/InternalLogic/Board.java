/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalLogic;

/**
 *
 * @author admin
 */
public class Board {
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
    public Cell getCell(int row, int col)
    {
        return grid[row][col];
    }
}
