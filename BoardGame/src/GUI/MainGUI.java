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
    public static final int PANEL_HEIGHT = 800;
    public static final int PANEL_WIDTH = 800;
    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = 100;

    // main Panel for overall display
    private static DrawingPanel mainPanel;

    private static enum BUTTON
    {
        StartButton("Start Game", 1), InstructionsButton("Instructions", 2);

        private String name;
        private int index;

        private BUTTON(String _name, int _index)
        {
            name = _name;
            index = _index;
        }
    }

    // contents for MainPanel
    // private static ArrayList<Rectangle> Buttons;
    private static MainMenuGUI primaryMenu;

    public static void main(String[] arg)
    {
        DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
        Graphics g = panel.getGraphics();

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
        primaryMenu.displayAll(g);

        /*
        // listen for key presses
        RectangleKeyListener listener = new RectangleKeyListener(panel, list);
        panel.addKeyListener(listener);
        * */
        // listen for mouse clicks
        RectangleMouseListener listener2 = new RectangleMouseListener(panel);
        panel.addMouseListener(listener2);

    }

    // A class for responding to mouse clicks on the drawing panel.
    public static class RectangleMouseListener extends MouseInputAdapter
    {
        private DrawingPanel panel;


        public RectangleMouseListener(DrawingPanel panel)
        {
            this.panel = panel;
        }

        @Override
        public void mousePressed(MouseEvent event)
        {
            int x = event.getX() / panel.getZoom();
            int y = event.getY() / panel.getZoom();

            System.out.println(x + " " + y);

            checkClick(x, y);
        }

        private void checkClick(int x, int y)
        {
            if(x > (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2)
                && x < (PANEL_WIDTH / 2 - BUTTON_WIDTH / 2 + BUTTON_WIDTH)
                && y > (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 5.75)
                && y < (int) (PANEL_HEIGHT - BUTTON_HEIGHT * 5.75) + BUTTON_HEIGHT)
            {
                System.out.println("Start Game Instigated");
                panel.clear();

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
    }
}
