/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 *  Joseph Zhong
 *  ASSIGNMENT_NUMBER
 *  PROGRAM_DESCRIPTION
 *  PROGRAM_TITLE
 *  DATE
 *
 **/

public class CellGUI extends ButtonGUI
{
    private BufferedImage PieceImage;

    private boolean isPossibleMove;

    public CellGUI(int _x, int _y, int _width, int _height, Color _c, String _name)
    {
        super(_x, _y, _width, _height, _c, _name);
        isPossibleMove = true;
    }

    /** Draws this button using the given graphics pen. */
    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.WHITE);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }

    public void setPiece(BufferedImage _PieceImage)
    {
        if(isPossibleMove)
        {
            PieceImage = (BufferedImage) _PieceImage.getScaledInstance(getX(), getY(), Image.SCALE_DEFAULT);
        }
        isPossibleMove = false;
    }

    public void removePiece()
    {
        if(PieceImage != null)
        {
            PieceImage = null;
        }
    }
}
