/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalLogic;

/**
 *
 * @author admin
 */
public class Cell {
    private int row;
    private int col;
    public Cell(int x, int y)
    {
        this.row = x;
        this.col = y;
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public boolean equals(Cell c)
    {
        return row == c.getRow() && col == c.getRow();
    }
}
