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

    private ArrayList<CellGUI> Cells;

    public GameBoardGUI()
    {
        Cells = new ArrayList<>();


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
                if((c == 2 || c == 3 || c == 6 || c == 7)
                        && (r == 4 || r == 5))
                {
                    _isWater = true;
                }
                else
                {
                    _isWater = false;
                }
                CellGUI tempCell = new CellGUI(r * CellLength, c * CellLength,
                        CellLength, CellLength, Color.PINK, ".", _isWater);
                if(tempCell.getIsWater())
                {

                }

                Cells.add(tempCell);
            }
        }
    }

    public int getCells()
    {
        return LENGTH * LENGTH;
    }

    public CellGUI getCell(int i)
    {
        return Cells.get(i);
    }

}
