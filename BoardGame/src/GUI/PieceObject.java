/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.image.BufferedImage;
import BoardGame.*;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 *  Joseph Zhong
 *  ASSIGNMENT_NUMBER
 *  PROGRAM_DESCRIPTION
 *  PROGRAM_TITLE
 *  DATE
 *
 **/

public class PieceObject
{
    private BufferedImage PieceImage;

    private final String TEN = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Marshal.png";
    private final String NINE = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/General.png";
    private final String EIGHT = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Colonel.png";
    private final String SEVEN = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Major.png";
    private final String SIX = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Captain.png";
    private final String FIVE = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Liuetenant.png";
    private final String FOUR = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Sergant.png";
    private final String THREE = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Minor.png";
    private final String TWO = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Scout.png";
    private final String ONE = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Flag.png";
    private final String ZERO = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Bomb.png";

    private int power;

    public PieceObject()
    {
        PieceImage = null;
    }

    public PieceObject(int _power)
    {
        power = _power;
        if(_power == 0)
        {
            try
            {
                PieceImage = ImageIO.read(new File(ZERO));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 1)
        {
            try
            {
                PieceImage = ImageIO.read(new File(ONE));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 2)
        {
            try
            {
                PieceImage = ImageIO.read(new File(TWO));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 3)
        {
            try
            {
                PieceImage = ImageIO.read(new File(THREE));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 4)
        {
            try
            {
                PieceImage = ImageIO.read(new File(FOUR));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 5)
        {
            try
            {
                PieceImage = ImageIO.read(new File(FIVE));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 6)
        {
            try
            {
                PieceImage = ImageIO.read(new File(SIX));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 7)
        {
            try
            {
                PieceImage = ImageIO.read(new File(SEVEN));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 8)
        {
            try
            {
                PieceImage = ImageIO.read(new File(EIGHT));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 9)
        {
            try
            {
                PieceImage = ImageIO.read(new File(NINE));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == 10)
        {
            try
            {
                PieceImage = ImageIO.read(new File(TEN));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
    }

    public int getPower()
    {
        return power;
    }

    public BufferedImage getImage()
    {
        return PieceImage;
    }

    public void drawImage(Graphics g)
    {
        g.drawImage(PieceImage, power, power, power, power, null);
    }
}
