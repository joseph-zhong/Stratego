/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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

public class MainGUI extends JFrame
{
    // constants for the drawing panel size, tile sizes, and # of tiles
    public static final int PANEL_HEIGHT = 600;
    public static final int PANEL_WIDTH = 1000;
    public static final int GAME_WIDTH = 600;
    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = 100;

    private static boolean menuStage;

    // main Graphics
    private static Graphics mainGraphics;

    // main Panel for overall display
    private static DrawingPanel mainPanel;

    private static GameBoardGUI mainBoard;

    // contents for MainPanel
    // private static ArrayList<Rectangle> Buttons;
    private static MainMenuGUI primaryMenu;

    private static void initComponents()
    {
        mainPanel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
        mainGraphics = mainPanel.getGraphics();
        mainBoard = new GameBoardGUI();
        menuStage = true;
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

        /*
        // listen for key presses
        RectangleKeyListener listener = new RectangleKeyListener(panel, list);
        panel.addKeyListener(listener);
        * */

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

            checkClick(x, y);
        }

        private void checkClick(int x, int y)
        {
            if(menuStage)
            {
                if(x > (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2)
                    && x < (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2 + BUTTON_WIDTH)
                    && y > (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 5.75)
                    && y < (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 5.75) + BUTTON_HEIGHT)
                {
                    System.out.println("Start Game Instigated");
                    panel.clear();
                    mainBoard.buildGameBoard(GAME_WIDTH / 10);
                    for(int i = 0; i < mainBoard.getCells(); i++)
                    {
                        mainBoard.getCell(i).draw(mainGraphics);
                    }
                }
                else if(x > (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2)
                    && x < (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2 + BUTTON_WIDTH)
                    && y > (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 4.25)
                    && y < (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 4.25) + BUTTON_HEIGHT)
                {
                    System.out.println("Instructions Instigated");
                    panel.clear();
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
            menuStage = false;
        }
    }
}
