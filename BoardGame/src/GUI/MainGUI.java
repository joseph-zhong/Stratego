
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
    private static boolean playStage;

    private static int marshalCounter;
    private static int generalCounter;
    private static int colonelCounter;
    private static int majorCounter;
    private static int captainCounter;
    private static int lieutenantCounter;
    private static int sergeantCounter;
    private static int minerCounter;
    private static int scoutCounter;
    private static int spyCounter;
    private static int bombCounter;
    private static int flagCounter;

    private static int r1;
    private static int r2;
    private static int c1;
    private static int c2;

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
        playStage = true;
        MainManager = new GameControl();

        marshalCounter = 0;
        generalCounter = 0;
        colonelCounter = 0;
        majorCounter = 0;
        captainCounter = 0;
        lieutenantCounter = 0;
        sergeantCounter = 0;
        minerCounter = 0;
        scoutCounter = 0;
        spyCounter = 0;
        bombCounter = 0;
        flagCounter = 0;

        r1 = -1;
        r2 = -1;
        c1 = -1;
        c2 = -1;
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

//                    MainManager.getComputer().flagSetUp();

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
                                    mainBoard.subtractHighlighted();
                                }
                                else
                                {
                                    if(mainBoard.addHighlighted())
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

            }
            else if(playStage)
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
                            System.out.println("Play Cell click detected: " + r + ", " + c);
                            // highlight
                            if(!mainBoard.getCells()[r][c].getIsWater())
                            {
                                if(mainBoard.getCells()[r][c].getIsHighlighted())
                                {
                                    mainBoard.getCells()[r][c].setIsHighlighted(false);
                                    mainBoard.getCells()[r][c].setColor(mainGraphics, Color.WHITE);
                                    mainBoard.subtractHighlighted();
                                    if(r == r1)
                                    {
                                        r1 = -1;
                                        c1 = -1;
                                    }
                                    else
                                    {
                                        r2 = -1;
                                        c1 = -1;
                                    }
                                }
                                else
                                {
                                    if(mainBoard.addHighlighted())
                                    {
                                        mainBoard.getCells()[r][c].setIsHighlighted(true);
                                        mainBoard.getCells()[r][c].setColor(mainGraphics, Color.MAGENTA);
                                        if(r1 ==-1)
                                        {
                                            r1 = r;
                                            c1 = c;
                                        }
                                        else
                                        {
                                            r2 = r;
                                            c2 = c;

                                            if(MainManager.getBoard().canMove(r1, c1, r2, c2))
                                            {
                                                MainManager.getBoard().move(r1, c1, r2, c2);
                                                System.out.println("Move Succesful");
                                                    // Aaron does this internally change the pieces?
                                                for(int row = 0; row < mainBoard.getCells()[0].length; row++)
                                                {
                                                    for (int col = 0; col < mainBoard.getCells()[1].length; col++)
                                                    {
                                                        //if(MainManager.getBoard().getCell(row, col).get().getPower() == 0)
                                                        if(MainManager.getBoard().getCell(row, col).get() != null)
                                                        {
                                                            //System.out.println("Hello Joseph");
                                                            if(MainManager.getBoard().getCell(row, col).get().equals(new Sergeant()))
                                                            {
                                                                mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                                                    mainBoard.getCells()[r][c].getX(),
                                                                    mainBoard.getCells()[r][c].getY(),
                                                                    mainBoard.getCells()[r][c].getWidth(),
                                                                    mainBoard.getCells()[r][c].getHeight());
                                                                MainManager.getBoard().getCell(r, c).put(new Sergeant());
                                                            }

                                                        }
                                                    }
                                                }
                                            }
                                            else
                                            {
                                                mainBoard.getCells()[r1][c1].setIsHighlighted(false);
                                                mainBoard.getCells()[r2][c2].setIsHighlighted(false);
                                                mainBoard.subtractHighlighted();
                                                mainBoard.subtractHighlighted();
                                                r1 = -1; c1 = -1; r2 = -1; c2 = -1;
                                                System.out.println("Move Not Successful");
                                            }
                                        }
                                    }
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
            if(marshalCounter == 1 && generalCounter == 1 && colonelCounter == 2
                && majorCounter == 3 && captainCounter == 4 && lieutenantCounter == 4
                && sergeantCounter == 4 && minerCounter == 5 && scoutCounter == 8
                && spyCounter == 1 && bombCounter == 6 && flagCounter == 1)
            {
                gameStage = false;
            }

            int key = e.getKeyCode();
            for(int r = 0; r < mainBoard.getCells()[0].length; r++)
            {
                for(int c = 0; c < mainBoard.getCells()[1].length; c++)
                {

                    if(key == KeyEvent.VK_0)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && marshalCounter < 1)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(0));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                mainBoard.getCells()[r][c].getX(),
                                mainBoard.getCells()[r][c].getY(),
                                mainBoard.getCells()[r][c].getWidth(),
                                mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Marshal());
                            marshalCounter++;
                        }

                    }
                    else if(key == KeyEvent.VK_1)
                    {
                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && spyCounter < 1)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(1));
                             mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                mainBoard.getCells()[r][c].getX(),
                                mainBoard.getCells()[r][c].getY(),
                                mainBoard.getCells()[r][c].getWidth(),
                                mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Spy());
                            spyCounter++;
                        }

                    }
                    else if(key == KeyEvent.VK_2)
                    {
                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && scoutCounter < 8)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(2));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                mainBoard.getCells()[r][c].getX(),
                                mainBoard.getCells()[r][c].getY(),
                                mainBoard.getCells()[r][c].getWidth(),
                                mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Scout());
                            scoutCounter++;
                        }
                    }
                    else if(key == KeyEvent.VK_3)
                    {
                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && minerCounter < 5)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(3));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Miner());
                            minerCounter++;
                        }
                    }
                    else if(key == KeyEvent.VK_4)
                    {
                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && sergeantCounter < 4)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(4));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Sergeant());
                            sergeantCounter++;
                        }
                    }
                    else if(key == KeyEvent.VK_5)
                    {
                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && lieutenantCounter < 4)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(5));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Lieutenant());
                            lieutenantCounter++;
                        }
                    }
                    else if(key == KeyEvent.VK_6)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && captainCounter < 4)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(6));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Captain());
                            captainCounter++;
                        }
                    }
                    else if(key == KeyEvent.VK_7)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && majorCounter < 3)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(7));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Major());
                            majorCounter++;
                        }

                    }else if(key == KeyEvent.VK_8)
                    {
                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && colonelCounter < 2)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(8));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Colonel());
                            colonelCounter++;
                        }
                    }
                    else if(key == KeyEvent.VK_9)
                    {
                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && generalCounter < 1)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject(9));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new General());
                            generalCounter++;
                        }
                    }
                    else if(key == KeyEvent.VK_B)
                    {
                        //mainBoard.getCells()[r][c].setPiece(null);

                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && bombCounter < 6)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject('b'));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Bomb());
                            bombCounter++;
                        }
                    }
                    else if(key == KeyEvent.VK_F)
                    {
                        if(mainBoard.getCells()[r][c].getIsHighlighted()
                            && flagCounter < 1)
                        {
                            mainBoard.getCells()[r][c].setPiece(new PieceObject('f'));
                            mainBoard.getCells()[r][c].getPiece().drawImage(mainGraphics,
                                    mainBoard.getCells()[r][c].getX(),
                                    mainBoard.getCells()[r][c].getY(),
                                    mainBoard.getCells()[r][c].getWidth(),
                                    mainBoard.getCells()[r][c].getHeight());
                            MainManager.getBoard().getCell(r, c).put(new Flag());
                            flagCounter++;
                        }
                    }
                    mainBoard.getCells()[r][c].setIsHighlighted(false);
                    mainBoard.subtractHighlighted();
                }
            }
        }
    }

}
