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
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.event.MouseInputAdapter;

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
    private PieceObject PieceObject;

    private boolean isPossibleMove;
    private boolean isWater;
    private boolean isHighlighted;

    public CellGUI(int _x, int _y, int _width, int _height, Color _c, String _name, boolean _isWater)
    {
        super(_x, _y, _width, _height, _c, _name);
        isPossibleMove = true;
        isWater = _isWater;
        isHighlighted = false;
    }

    /** Draws this button using the given graphics pen. */
    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.WHITE);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }

    public void setColor(Graphics g, Color _c)
    {
        g.setColor(_c);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }

    public void setPiece(PieceObject _PieceObject)
    {
        if(isPossibleMove)
        {
            PieceObject = _PieceObject;
        }
        isPossibleMove = false;
    }

    public void removePiece()
    {
        if(PieceObject != null)
        {
            PieceObject = null;
        }
    }

    public PieceObject getPiece()
    {
        return PieceObject;
    }

    public boolean getIsWater()
    {
        return isWater;
    }

    public void setIsHighlighted(boolean setIsHighlighted)
    {
        isHighlighted = setIsHighlighted;
    }

    public boolean getIsHighlighted()
    {
        return isHighlighted;
    }

    // A class for responding to mouse clicks on the drawing panel.
    public static class RectangleMouseListener extends MouseInputAdapter
    {
        private DrawingPanel panel;


        public RectangleMouseListener(DrawingPanel _panel)
        {
            panel = _panel;
        }

        @Override
        public void mousePressed(MouseEvent evt)
        {
            int x = evt.getX() / panel.getZoom();
            int y = evt.getY() / panel.getZoom();

            System.out.println(x + " " + y);

        }
    }
}
