/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import InternalLogic.*;
import Pieces.*;

/**
 *
 *  Joseph Zhong
 *  ASSIGNMENT_NUMBER
 *  PROGRAM_DESCRIPTION
 *  PROGRAM_TITLE
 *  DATE
 *
 **/

public class MainGUI extends JFrame
{
    // constants for the drawing panel size, tile sizes, and # of tiles
    public static final int PANEL_HEIGHT = 600;
    public static final int PANEL_WIDTH = 1000;
    public static final int GAME_WIDTH = 600;

    public static final int GAME_FIGHT = 200;
    public static final int GAME_CELL= 200;
    public static final int GAME_GLOBAL = 150;
    public static final int GAME_CONSOLE = 50;

    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = 100;

    private static boolean menuStage;
    private static boolean gameStage;

    // main Graphics
    private static Graphics mainGraphics;

    // main Panel for overall display
    private static DrawingPanel mainPanel;

    private static GameBoardGUI mainBoard;

    // contents for MainPanel
    // private static ArrayList<Rectangle> Buttons;
    private static MainMenuGUI primaryMenu;

    private static GameControl MainManager;

    private static void initComponents()
    {
        mainPanel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
        mainGraphics = mainPanel.getGraphics();
        mainBoard = new GameBoardGUI();
        menuStage = true;
        gameStage = true;
        MainManager = new GameControl();
    }

    public static void main(String[] arg)
    {
        initComponents();

        primaryMenu = new MainMenuGUI();

        ButtonGUI StartButton = new ButtonGUI(PANEL_WIDTH / 2 - BUTTON_WIDTH / 2,
            (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 5.75), BUTTON_WIDTH, BUTTON_HEIGHT,
            Color.ORANGE, "Start Game");
        primaryMenu.addButton(StartButton);

        ButtonGUI InstructionsButton = new ButtonGUI(PANEL_WIDTH / 2 - BUTTON_WIDTH / 2,
            (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 4.25), BUTTON_WIDTH, BUTTON_HEIGHT, Color.ORANGE, "Instructions");
        primaryMenu.addButton(InstructionsButton);

        ButtonGUI HallOfFameButton = new ButtonGUI(PANEL_WIDTH / 2 - BUTTON_WIDTH / 2,
            (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 2.75), BUTTON_WIDTH, BUTTON_HEIGHT,
            Color.ORANGE, "Hall of Fame");
        primaryMenu.addButton(HallOfFameButton);

        ButtonGUI QuitButton = new ButtonGUI(PANEL_WIDTH / 2 - BUTTON_WIDTH / 2,
            (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 1.25), BUTTON_WIDTH, BUTTON_HEIGHT, Color.ORANGE, "Quit");
        primaryMenu.addButton(QuitButton);

        /*
        for(int i = 0; i < options; i++)
        {
            primaryMenu.addButton(new Button(PANEL_WIDTH / ));
        }
*/

        primaryMenu.displayAll(mainGraphics);


        // listen for key presses
        RectangleKeyListener listener = new RectangleKeyListener(mainPanel);
        mainPanel.addKeyListener(listener);

        // listen for mouse clicks
        RectangleMouseListener listener2 = new RectangleMouseListener(mainPanel);
        mainPanel.addMouseListener(listener2);
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

            checkClick(evt, x, y);
        }

        private void checkClick(MouseEvent _e, int x, int y)
        {
            if(menuStage)
            {
                if(x > (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2)
                    && x < (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2 + BUTTON_WIDTH)
                    && y > (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 5.75)
                    && y < (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 5.75) + BUTTON_HEIGHT)
                {
                    menuStage = false;
                    System.out.println("Start Game Instigated");
                    panel.clear();
                    mainBoard.buildGameBoard(GAME_WIDTH / 10);
                    /*
                    for(int i = 0; i < mainBoard.getCells().size(); i++)
                    {
                        mainBoard.getCells().get(i).draw(mainGraphics);
                    }
                    * */
                    for(int r = 0; r < mainBoard.getCells()[0].length; r++)
                    {
                        for(int c = 0; c < mainBoard.getCells()[1].length; c++)
                        {
                            mainBoard.getCells()[r][c].draw(mainGraphics);
                        }
                    }
                }
                else if(x > (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2)
                    && x < (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2 + BUTTON_WIDTH)
                    && y > (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 4.25)
                    && y < (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 4.25) + BUTTON_HEIGHT)
                {
                    System.out.println("Instructions Instigated");
                    panel.clear();
                    menuStage = false;
                    gameStage = false;
                }
                else if(x > (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2)
                    && x < (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2 + BUTTON_WIDTH)
                    && y > (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 2.75)
                    && y < (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 2.75) + BUTTON_HEIGHT)
                {
                    System.out.println("Hall Of Fame Instigated");

                }
                else if(x > (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2)
                    && x < (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2 + BUTTON_WIDTH)
                    && y > (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 1.25)
                    && y < (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 1.25) + BUTTON_HEIGHT)
                {
                    System.out.println("Quit Instigated");
                    System.exit(0);
                }
            }
            else if(gameStage)
            {
                for(int r = 0; r < mainBoard.getCells()[0].length; r++)
                {
                    for(int c = 0; c < mainBoard.getCells()[1].length; c++)
                    {
                        if(x > mainBoard.getCells()[r][c].getX()
                            && x < mainBoard.getCells()[r][c].getX() + mainBoard.getCells()[r][c].getWidth()
                            && y > mainBoard.getCells()[r][c].getY()
                            && y < mainBoard.getCells()[r][c].getY() + mainBoard.getCells()[r][c].getHeight())
                        {
                            System.out.println("Cell click detected: " + r + ", " + c);
                            // highlight
                            if(!mainBoard.getCells()[r][c].getIsWater())
                            {
                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setIsHighlighted(false);
                                    mainBoard.getCells()[r][c].setColor(mainGraphics, Color.WHITE);
                                }
                                else
                                {
                                    mainBoard.getCells()[r][c].setIsHighlighted(true);
                                    mainBoard.getCells()[r][c].setColor(mainGraphics, Color.MAGENTA);
                                    showCellHUD(mainGraphics);
                                }
                            }
                        }
                    }
                }
            }
        }// end of checkClick
    }

    private static void showCellHUD(Graphics g)
    {
        System.out.println("Enter number respresenting piece");
        g.drawString("Enter number respresenting piece: ", GAME_WIDTH, PANEL_HEIGHT - GAME_CELL);
    }

    public static class RectangleKeyListener extends KeyAdapter
    {
        private DrawingPanel panel;

        public RectangleKeyListener(DrawingPanel _panel)
        {
            panel = _panel;
        }

        /** Handle the key-pressed event from the text field. */
        public void keyPressed(KeyEvent e)
        {
            int key = e.getKeyCode();
            for(int r = 0; r < mainBoard.getCells()[0].length; r++)
            {
                for(int c = 0; c < mainBoard.getCells()[1].length; c++)
                {

                    if(key == KeyEvent.VK_0)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                        if(mainBoard.getCells()[r][c].getIsHighlighted())
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(0));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                mainBoard.getCells()[r][c].getX(),
                                mainBoard.getCells()[r][c].getY(),
                                mainBoard.getCells()[r][c].getWidth(),
                                mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Marshal());
                        }

                    }
                    else if(key == KeyEvent.VK_1)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                        if(mainBoard.getCells()[r][c].getIsHighlighted())
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(1));
                             mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                mainBoard.getCells()[r][c].getX(),
                                mainBoard.getCells()[r][c].getY(),
                                mainBoard.getCells()[r][c].getWidth(),
                                mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Flag());
                        }

                    }
                    else if(key == KeyEvent.VK_2)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject(2));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                        mainBoard.getCells()[r][c].getX(),
                                        mainBoard.getCells()[r][c].getY(),
                                        mainBoard.getCells()[r][c].getWidth(),
                                        mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new Scout());
                                }
                    }
                    else if(key == KeyEvent.VK_3)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject(3));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                            mainBoard.getCells()[r][c].getX(),
                                            mainBoard.getCells()[r][c].getY(),
                                            mainBoard.getCells()[r][c].getWidth(),
                                            mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new Miner());
                                }

                    }
                    else if(key == KeyEvent.VK_4)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject(4));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                            mainBoard.getCells()[r][c].getX(),
                                            mainBoard.getCells()[r][c].getY(),
                                            mainBoard.getCells()[r][c].getWidth(),
                                            mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new Sergeant());
                                }

                    }
                    else if(key == KeyEvent.VK_5)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject(5));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                            mainBoard.getCells()[r][c].getX(),
                                            mainBoard.getCells()[r][c].getY(),
                                            mainBoard.getCells()[r][c].getWidth(),
                                            mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new Lieutenant());
                                }

                    }
                    else if(key == KeyEvent.VK_6)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject(6));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                            mainBoard.getCells()[r][c].getX(),
                                            mainBoard.getCells()[r][c].getY(),
                                            mainBoard.getCells()[r][c].getWidth(),
                                            mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new Captain());
                                }

                    }
                    else if(key == KeyEvent.VK_7)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject(7));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                            mainBoard.getCells()[r][c].getX(),
                                            mainBoard.getCells()[r][c].getY(),
                                            mainBoard.getCells()[r][c].getWidth(),
                                            mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new Major());
                                }

                    }else if(key == KeyEvent.VK_8)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject(8));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                            mainBoard.getCells()[r][c].getX(),
                                            mainBoard.getCells()[r][c].getY(),
                                            mainBoard.getCells()[r][c].getWidth(),
                                            mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new Colonel());
                                }

                    }
                    else if(key == KeyEvent.VK_9)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject(9));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                            mainBoard.getCells()[r][c].getX(),
                                            mainBoard.getCells()[r][c].getY(),
                                            mainBoard.getCells()[r][c].getWidth(),
                                            mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new General());
                                }

                    }
                    else if(key == KeyEvent.VK_B)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setPiece(new PieceObject('b'));
                                    mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                            mainBoard.getCells()[r][c].getX(),
                                            mainBoard.getCells()[r][c].getY(),
                                            mainBoard.getCells()[r][c].getWidth(),
                                            mainBoard.getCells()[r][c].getHeight());
                                    MainManager.getBoard().getCell(r, c).put(new Bomb());
                                }

                    }
                    mainBoard.getCells()[r][c].setIsHighlighted(false);

                }
            }


        }
    }

}
