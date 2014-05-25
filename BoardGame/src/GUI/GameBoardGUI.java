/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 *  Joseph Zhong
 *  ASSIGNMENT_NUMBER
 *  PROGRAM_DESCRIPTION
 *  PROGRAM_TITLE
 *  DATE
 *
 **/

public class GameBoardGUI
{
    private static final int LENGTH = 10;

    //private ArrayList<CellGUI> Cells;
    private CellGUI Cells[][];

    public GameBoardGUI()
    {
        //Cells = new ArrayList<>();
        Cells = new CellGUI[LENGTH][LENGTH];

        /*
        CellGUI c1 = new CellGUI(20, 20, 10, 10, Color.BLACK, "Test");
        Cells.add(c1);
        * */
    }

    public void buildGameBoard(int CellLength)
    {
        for(int r = 0; r < LENGTH; r++)
        {
            for(int c = 0; c < LENGTH; c++)
            {
                boolean _isWater;
                if((r == 2 || r == 3 || r == 6 || r == 7)
                        && (c == 4 || c == 5))
                {
                    _isWater = true;
                }
                else
                {
                    _isWater = false;
                }

                CellGUI tempCell;
                if(_isWater)
                {
                     tempCell = new CellGUI(r * CellLength, c * CellLength,
                        CellLength, CellLength, Color.CYAN, ".", _isWater);
                }
                else
                {
                    tempCell = new CellGUI(r * CellLength, c * CellLength,
                        CellLength, CellLength, Color.ORANGE, ".", _isWater);
                }

                //Cells.add(tempCell);
                Cells[r][c] = tempCell;
            }
        }
    }
/*
    public int getCells()
    {
        return LENGTH * LENGTH;
    }

    public CellGUI getCell(int i)
    {
        return Cells.get(i);
    }

* */
    public CellGUI[][] getCells()
    {
        return Cells;
    }
}
