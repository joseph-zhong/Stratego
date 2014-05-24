/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boardgame;

import java.awt.Graphics;

/**
 *
 *  Joseph Zhong
 *  ASSIGNMENT_NUMBER
 *  PROGRAM_DESCRIPTION
 *  PROGRAM_TITLE
 *  DATE
 *
 **/

public class MainGUI
{
    // constants for the drawing panel size, tile sizes, and # of tiles
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    public static final int MIN_SIZE = 100;
    public static final int MAX_SIZE = 200;

    // main Panel for overall display
    private static DrawingPanel mainPanel;



    public static void main(String[] arg)
    {

        DrawingPanel panel = new DrawingPanel(HEIGHT, WIDTH);
        Graphics g = panel.getGraphics();

        /*
        // create several random tiles and put them into a manager
        TileManager list = new TileManager();
        for (int i = 0; i < TILES; i++) {
            Tile tile = makeRandomTile();
            list.addTile(tile);
        }
        list.drawAll(g);

        // listen for key presses
        RectangleKeyListener listener = new RectangleKeyListener(panel, list);
        panel.addKeyListener(listener);

        // listen for mouse clicks
        RectangleMouseListener listener2 = new RectangleMouseListener(panel, list);
        panel.addMouseListener(listener2);
        * */
    }
}
