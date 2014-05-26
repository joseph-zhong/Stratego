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

    private final String MARSHAL = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Marshal.png";
    private final String GENERAL = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/General.png";
    private final String COLONEL = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Colonel.png";
    private final String MAJOR = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Major.png";
    private final String CAPTAIN = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Captain.png";
    private final String LIEUTENANT = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Lieutenant.png";
    private final String SERGEANT = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Sergeant.png";
    private final String MINER = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Miner.png";
    private final String SCOUT = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Scout.png";
    private final String SPY = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Spy.png";
    private final String FLAG = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Flag.png";
    private final String BOMB = "C:/Users/Joseph/Downloads/GitHub/CodeDay3AI-2014/BoardGame/src/Images/Bomb.png";

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
                PieceImage = ImageIO.read(new File(MARSHAL));
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
                PieceImage = ImageIO.read(new File(SPY));
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
                PieceImage = ImageIO.read(new File(SCOUT));
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
                PieceImage = ImageIO.read(new File(MINER));
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
                PieceImage = ImageIO.read(new File(SERGEANT));
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
                PieceImage = ImageIO.read(new File(LIEUTENANT));
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
                PieceImage = ImageIO.read(new File(CAPTAIN));
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
                PieceImage = ImageIO.read(new File(MAJOR));
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
                PieceImage = ImageIO.read(new File(COLONEL));
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
                PieceImage = ImageIO.read(new File(GENERAL));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == (int) 'f')
        {
            try
            {
                PieceImage = ImageIO.read(new File(FLAG));
            }
            catch (IOException e)
            {
                System.out.println("File not found");
            }
        }
        else if(_power == (int) 'b')
        {
            try
            {
                PieceImage = ImageIO.read(new File(BOMB));
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

    public void drawImage(Graphics g, int _x, int _y, int _width, int _height)
    {
        g.drawImage(PieceImage, _x, _y, _width, _height, null);
    }
}
